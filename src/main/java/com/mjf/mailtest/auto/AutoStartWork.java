package com.mjf.mailtest.auto;

import com.mjf.mailtest.quartz.MyScheduler;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author mjf
 * @version 1.0
 * @date 2021/11/25 21:45
 */

@Component
public class AutoStartWork implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        MyScheduler.getScheduler().start();
    }
}
