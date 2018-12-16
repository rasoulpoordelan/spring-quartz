package com.onetechone.myquartz.myquartz.service;

import static org.quartz.JobBuilder.newJob;

import com.onetechone.myquartz.myquartz.job.TestJob;
import com.onetechone.myquartz.myquartz.job.TestSecJob;
import com.onetechone.myquartz.myquartz.job.TestThirdJob;
import com.onetechone.myquartz.myquartz.model.Person;
import com.onetechone.myquartz.myquartz.repository.PersonRepository;
import java.util.List;
import org.joda.time.LocalDateTime;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class JobService {

  @Autowired
  SchedulerFactoryBean schedulerFactoryBean;

  public void startWithLimitedCount() throws SchedulerException {

    JobDetail job = newJob(TestSecJob.class)
        .withIdentity("myJob10", "group_10")
        .build();

    Trigger trigger = TriggerBuilder.newTrigger()
        .withIdentity("myTrigger10", "group10")
        .startNow()
        .withSchedule(SimpleScheduleBuilder.simpleSchedule()
            .withRepeatCount(10)
            .withIntervalInSeconds(2))
        .build();

    schedulerFactoryBean.getObject().scheduleJob(job, trigger);

  }

  public void startForEver() throws SchedulerException {

    JobDetail job = newJob(TestJob.class)
        .withIdentity("myJob20", "group_20")
        .build();

    Trigger trigger = TriggerBuilder.newTrigger()
        .withIdentity("myTrigger20", "group20")
        .startNow()
        .withSchedule(SimpleScheduleBuilder.simpleSchedule()
            .repeatForever()
            .withIntervalInSeconds(3))
        .build();

    schedulerFactoryBean.getObject().scheduleJob(job, trigger);

  }


  public void startInSpacificTime() throws SchedulerException {

    JobDetail job = newJob(TestThirdJob.class)
        .withIdentity("myJob30", "group_30")
        .build();

    Trigger trigger = TriggerBuilder.newTrigger()
        .withIdentity("myTrigger30", "group30")
        .startAt(LocalDateTime.now().plusSeconds(6).toDate())
        .build();

    schedulerFactoryBean.getObject().scheduleJob(job, trigger);
  }

}