package com.example.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.TestService;

public class MySimpleJob implements Job {

	@Autowired
	private TestService service;

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		service.processData();
	}
}