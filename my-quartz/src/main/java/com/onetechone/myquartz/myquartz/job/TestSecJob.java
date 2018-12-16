package com.onetechone.myquartz.myquartz.job;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

public class TestSecJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("===================Hello =============== " + new Date());
    }
}
