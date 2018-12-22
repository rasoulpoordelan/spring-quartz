package com.onetechone.myquartz.myquartz.job;

import com.onetechone.myquartz.myquartz.service.PersonService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

public class TestJob implements Job {

  @Autowired
  private PersonService personService;

  @Override
  public void execute(JobExecutionContext jobExecutionContext) {
    System.out.println("Hello " + personService.getName() + " World! Fired on " + new Date());
  }
}
