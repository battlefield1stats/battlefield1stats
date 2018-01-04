package com.bf1stats.main;

import com.bf1stats.jobs.GetBaseStatJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

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
