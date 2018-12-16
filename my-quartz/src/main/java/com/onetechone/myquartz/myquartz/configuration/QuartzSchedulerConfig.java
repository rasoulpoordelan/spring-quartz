package com.onetechone.myquartz.myquartz.configuration;

import com.zaxxer.hikari.HikariDataSource;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzSchedulerConfig {

  @Autowired
  ApplicationContext applicationContext;


  private static final String PROPERTY_NAME_DB_DRIVER_CLASS = "quartz.db.driver";
  private static final String PROPERTY_NAME_DB_PASSWORD = "quartz.db.password";
  private static final String PROPERTY_NAME_DB_URL = "quartz.db.url";
  private static final String PROPERTY_NAME_DB_USER = "quartz.db.username";

  private DataSource quartzDataSource;

  public QuartzSchedulerConfig(Environment env) {

    HikariDataSource dataSourceConfig = new HikariDataSource();
    dataSourceConfig.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
    dataSourceConfig.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DB_URL));
    dataSourceConfig.setUsername(env.getRequiredProperty(PROPERTY_NAME_DB_USER));
    dataSourceConfig.setPassword(env.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));
    quartzDataSource = new HikariDataSource(dataSourceConfig);
  }

  @Bean
  public Properties quartzProperties() throws IOException {
    PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
    propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
    propertiesFactoryBean.afterPropertiesSet();
    return propertiesFactoryBean.getObject();
  }

  @Bean
  public SchedulerFactoryBean schedulerFactoryBean() throws IOException {

    SchedulerFactoryBean factory = new SchedulerFactoryBean();
    factory.setOverwriteExistingJobs(true);
    factory.setDataSource(quartzDataSource);
    factory.setQuartzProperties(quartzProperties());
    factory.setApplicationContext(applicationContext);
    factory.start();
    return factory;
  }



}
