package com.bf1stats.jobs;

import com.bf1stats.client.DetailedStatsClient;
import com.bf1stats.client.VehiclesStatsClient;
import com.bf1stats.client.WeaponsStatsClient;
import com.bf1stats.dao.DetailedStatsDao;
import com.bf1stats.domain.db.DetailedStatsDb;
import com.bf1stats.domain.json.basic.DetailedStatsResponseJson;
import com.bf1stats.domain.json.vehicles.VehiclesResponseJson;
import com.bf1stats.domain.json.weapons.WeaponsResponseJson;
import com.bf1stats.transformers.DetailedStatsTransformer;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Optional;

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

    private static Logger LOGGER = LoggerFactory.getLogger(PersistDetailedStatsJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LOGGER.info("Going to grab the update snapshot from TRN");

        DetailedStatsResponseJson detailedStatsResponseJson = detailedStatsClient.getFromResource(DetailedStatsResponseJson.class);
        VehiclesResponseJson vehiclesResponseJson = vehiclesStatsClient.getFromResource(VehiclesResponseJson.class);
        WeaponsResponseJson weaponsResponseJson = weaponsStatsClient.getFromResource(WeaponsResponseJson.class);

        LOGGER.info("Converting.");

        DetailedStatsDb detailedStatsDb = detailedStatsTransformer.transform(detailedStatsResponseJson.getResult(), vehiclesResponseJson.getResult(), weaponsResponseJson.getResult());
        Optional<DetailedStatsDb> latest = detailedStatsDao.findFirstByOrderByRecordedDesc();

        if (!latest.isPresent() || detailedStatsDb.getTimePlayed() > latest.get().getTimePlayed()) {
            LOGGER.info("Data obtained from API is newer. Going to persist.");
            detailedStatsDao.save(detailedStatsDb);
        } else {
            LOGGER.info("New data is equal to latest persisted. Nothing to do.");
        }

        LOGGER.info("Scheduled job is finished.");
    }
}
