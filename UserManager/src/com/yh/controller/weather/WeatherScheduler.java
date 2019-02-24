package com.yh.controller.weather;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class WeatherScheduler {
	
	public static void main(String[] args) throws Exception {
		
		//调度器(Scheduler);从工厂中获取调度的实例：new StdSchedulerFactory;
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		//任务实例(JobDetail)
		JobDetail jobDetail =  JobBuilder.newJob(WeatherController.class)//加载任务类，和WeatherController绑定;
				  .withIdentity("Job1", "GroupA")//任务名称和任务组名称；
				  .build();
		//TODO:
		SimpleScheduleBuilder.simpleSchedule();
		//触发器(Trigger)
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("Trigger1", "GroupB")
				.startNow()//立即启动触发器
				.withSchedule(CronScheduleBuilder.cronSchedule ("10 * * * * ?"))//每个整点触发一次  "0 0 0/1 * * ?"
				.build();
		//让调度器关联任务实例和触发器，按照触发器的触发规则去执行任务实例；
		scheduler.scheduleJob(jobDetail, trigger);
		//启动调度器
		scheduler.start();
	}
}
