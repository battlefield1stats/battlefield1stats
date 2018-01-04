package com.bf1stats.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class GetBaseStatJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.err.println("Triggered."); //TODO implement the call to the battlefieldtracker.com api
    }
}
