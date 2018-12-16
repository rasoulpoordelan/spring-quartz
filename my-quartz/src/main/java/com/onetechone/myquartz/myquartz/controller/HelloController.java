package com.onetechone.myquartz.myquartz.controller;

import com.onetechone.myquartz.myquartz.service.JobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  JobService jobService;

  @RequestMapping(value = "/start")
  public String startWithLimitedCount() throws SchedulerException {
    jobService.startWithLimitedCount();
    return "start with 10 count";
  }

  @RequestMapping(value = "/start2")
  public String startForEver() throws SchedulerException {
    jobService.startForEver();
    return "run for ever";
  }

  @RequestMapping(value = "/start3")
  public String startInSpecificTime() throws SchedulerException {
    jobService.startInSpacificTime();
    return "run one 6 second later";
  }

  @RequestMapping(value = "/start4")
  public String startWithData() throws SchedulerException {
    jobService.startInSpacificTimeWithDataOnce();
    return "run one with data";
  }

}
