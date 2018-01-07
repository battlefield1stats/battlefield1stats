package com.bf1stats.configuration;

import com.bf1stats.jobs.PersistDetailedStatsJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Configuration
public class ScheduledJobsConfiguration {

    @Value("${trn.api.refresh.period.hours:1}")
    private int refreshPeriodHours;

    @Bean
    public JobDetail getBaseStatsJobDetail() {
        return JobBuilder.newJob(PersistDetailedStatsJob.class)
                .withIdentity("getDetailedStats")
                .storeDurably().build();
    }

    @Bean
    public SimpleScheduleBuilder scheduleBuilder() {
        return SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInHours(refreshPeriodHours)
                .repeatForever();
    }

    @Bean
    @Autowired
    public Trigger sampleJobTrigger(SimpleScheduleBuilder scheduleBuilder, JobDetail getBaseStatsJobDetail) {
        return TriggerBuilder.newTrigger()
                .forJob(getBaseStatsJobDetail)
                .withIdentity("getStatsTrigger")
                .withSchedule(scheduleBuilder)
                .startAt(nextStartAt())
                .build();
    }

    private Date nextStartAt() {
        ZonedDateTime nextStart = ZonedDateTime.now().truncatedTo(ChronoUnit.HOURS).plusHours(1);
        return Date.from(nextStart.toInstant());
    }
}
