package com.onetechone.myquartz.myquartz.job;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class TestThirdJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("=================== Third =============== " + new Date());
    }
}
