package com.example.demo.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalJobListener implements JobListener {

	private static final String TRIGGER_LISTENER_NAME = "GlobalJobListener";
	private static final Logger LOG = LoggerFactory.getLogger(GlobalJobListener.class);

	@Override
	public String getName() {
		return TRIGGER_LISTENER_NAME;
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {

		var triggerName = context.getTrigger().getKey().toString();
		var jobName = context.getJobDetail().getKey().toString();
		LOG.info("trigger : " + triggerName + " is going to fire");
		LOG.info("job : " + jobName + "is going to fire");

	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

		var triggerName = context.getTrigger().getKey().toString();
		var jobName = context.getJobDetail().getKey().toString();
		LOG.info("trigger : " + triggerName + " is fired");
		LOG.info("job : " + jobName + " is fired");

	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		// TODO Auto-generated method stub

	}

}