package com.knowledgefactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SpringScheduler {

	// Scheduling a Task with Fixed Rate
	@Scheduled(fixedRate = 3000)
	public void scheduleTaskWithFixedRate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Scheduled task with Fixed Rate:" + sdf.format(cal.getTime()));
	}

	// Scheduling a Task with Fixed Delay

	@Scheduled(fixedDelay = 3000)
	public void scheduleTaskWithFixedDelay() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Scheduled task With with Fixed Delay:" + sdf.format(cal.getTime()));
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException ex) {
			throw new IllegalStateException(ex);
		}
	}

	// Scheduling a Task With Fixed Rate and Initial Delay
	@Scheduled(fixedRate = 3000, initialDelay = 6000)
	public void scheduleTaskWithInitialDelay() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Scheduled task With Fixed Rate and Initial Delay:" + sdf.format(cal.getTime()));
	}

	// Scheduling a Task using Cron Expression:every Christmas Day at midnight
	@Scheduled(cron = "0 0 0 25 12 ?")
	public void scheduleTaskWithCronExpression() {
		System.out.println("Scheduled Task using Cron Expression:every Christmas Day at midnight");
	}

}
