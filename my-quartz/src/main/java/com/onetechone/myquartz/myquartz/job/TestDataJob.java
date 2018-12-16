package com.onetechone.myquartz.myquartz.job;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;

public class TestDataJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String name = dataMap.getString("name");
        System.out.println("===================  " +name+" ================"+ new Date());
    }
}
