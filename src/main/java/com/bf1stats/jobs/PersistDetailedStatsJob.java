package com.bf1stats.jobs;

import com.bf1stats.client.DetailedStatsClient;
import com.bf1stats.client.VehiclesStatsClient;
import com.bf1stats.client.WeaponsStatsClient;
import com.bf1stats.dao.DetailedStatsDao;
import com.bf1stats.domain.db.DetailedStatsDb;
import com.bf1stats.domain.json.basic.DetailedStatsJson;
import com.bf1stats.domain.json.basic.DetailedStatsResponseJson;
import com.bf1stats.domain.json.vehicles.VehiclesJson;
import com.bf1stats.domain.json.vehicles.VehiclesResponseJson;
import com.bf1stats.domain.json.weapons.WeaponsJson;
import com.bf1stats.domain.json.weapons.WeaponsResponseJson;
import com.bf1stats.transformers.DetailedStatsTransformer;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

public class PersistDetailedStatsJob extends QuartzJobBean {

    @Autowired
    private DetailedStatsClient detailedStatsClient;

    @Autowired
    private VehiclesStatsClient vehiclesStatsClient;

    @Autowired
    private WeaponsStatsClient weaponsStatsClient;

    @Autowired
    private DetailedStatsDao detailedStatsDao;

    @Autowired
    private DetailedStatsTransformer detailedStatsTransformer;

    private ExecutorService jobExecutorService;

    private final int maxCount;

    public PersistDetailedStatsJob(@Value("${job.retry.count:5}") int jobRetryCount) {
        jobExecutorService = newExecutorService();
        maxCount = jobRetryCount;
    }

    private static Logger LOGGER = LoggerFactory.getLogger(PersistDetailedStatsJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        LOGGER.info("Going to grab the update snapshot from TRN");
        if (jobExecutorService.isShutdown()) {
            jobExecutorService = newExecutorService();
        }
        Future<DetailedStatsResponseJson> detailedStatsFuture = jobExecutorService.submit(
                () -> detailedStatsClient.getFromResource(DetailedStatsResponseJson.class)
        );
        Future<VehiclesResponseJson> vehiclesFuture = jobExecutorService.submit(
                () -> vehiclesStatsClient.getFromResource(VehiclesResponseJson.class)
        );
        Future<WeaponsResponseJson> weaponsFuture = jobExecutorService.submit(
                () -> weaponsStatsClient.getFromResource(WeaponsResponseJson.class)
        );

        DetailedStatsJson detailedStatsJson;
        List<VehiclesJson> vehiclesJson;
        List<WeaponsJson> weaponsJson;
        try {
            if (!jobExecutorService.awaitTermination(1L, TimeUnit.MINUTES)) {
                jobExecutorService.shutdownNow();
                throw new JobExecutionException("Timeout. Cancel client jobs.", context.getRefireCount() < maxCount);
            }
            detailedStatsJson = detailedStatsFuture.get().getResult();
            vehiclesJson = vehiclesFuture.get().getResult();
            weaponsJson = weaponsFuture.get().getResult();
        } catch (InterruptedException | ExecutionException e) {
            throw new JobExecutionException("Client has failed to get Detailed Stats from API", e, context.getRefireCount() < maxCount);
        }

        LOGGER.info("Converting.");

        DetailedStatsDb detailedStatsDb = detailedStatsTransformer.transform(detailedStatsJson, vehiclesJson, weaponsJson);
        Optional<DetailedStatsDb> latest = detailedStatsDao.findFirstByOrderByRecordedDesc();

        if (!latest.isPresent() || detailedStatsDb.getTimePlayed() > latest.get().getTimePlayed()) {
            LOGGER.info("Data obtained from API is newer. Going to persist.");
            detailedStatsDao.save(detailedStatsDb);
        } else {
            LOGGER.info("New data is equal to latest persisted. Nothing to do.");
        }

        LOGGER.info("Scheduled job is finished.");
    }

    private ExecutorService newExecutorService() {
        return Executors.newFixedThreadPool(3);
    }
}
