package com.bf1stats.configuration;

import com.bf1stats.jobs.GetBaseStatJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduledJobsConfiguration {

    @Bean
    public JobDetail getBaseStatsJobDetail() {
        return JobBuilder.newJob(GetBaseStatJob.class).withIdentity("getBaseStats")
                .storeDurably().build();
    }

    @Bean
    public SimpleScheduleBuilder scheduleBuilder() {
        return SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(2).repeatForever();
    }

    @Bean
    @Autowired
    public Trigger sampleJobTrigger(SimpleScheduleBuilder scheduleBuilder, JobDetail getBaseStatsJobDetail) {
        return TriggerBuilder.newTrigger().forJob(getBaseStatsJobDetail)
                .withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
    }
}
