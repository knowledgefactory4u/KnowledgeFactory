package com.example.demo.listener;

import javax.annotation.PostConstruct;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class JobListenerConfig {

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	@PostConstruct
	public void addListeners() throws SchedulerException {

		schedulerFactoryBean.getScheduler().getListenerManager().addJobListener(new GlobalJobListener());
	}
}
