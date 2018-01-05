package com.bf1stats.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class GetBaseStatJob extends QuartzJobBean {

    private static Logger LOGGER = LoggerFactory.getLogger(GetBaseStatJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LOGGER.info("Triggered."); //TODO implement the call to the battlefieldtracker.com api
    }
}
