package com.mjf.mailtest.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author mjf
 * @version 1.0
 * @date 2021/11/25 21:33
 */
public class MyScheduler {
    private static Scheduler scheduler;
    public static Scheduler getScheduler() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(AutoJob.class)
                .withIdentity("myJob").build();
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger")
                // 设置每5秒执行一次
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?")).build();
        SchedulerFactory factory = new StdSchedulerFactory();
        scheduler = factory.getScheduler();
        //scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
        return scheduler;
    }
}
