package com.mjf.mailtest.quartz;

import com.mjf.mailtest.mail.service.MailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

/**
 * @author mjf
 * @version 1.0
 * @date 2021/11/25 21:28
 */

@Component
public class AutoJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ServletContext context = null;

        try {
            context = (ServletContext) jobExecutionContext.getScheduler().getContext()
                    .get(QuartzServletContextListener.MY_CONTEXT_NAME);
        } catch (SchedulerException e1) {
            e1.printStackTrace();
        }
        WebApplicationContext cxt = (WebApplicationContext) context.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        MailService mailService = (MailService) cxt.getBean("mailServiceImpl");

        mailService.sendSimpleMail();
    }

}
