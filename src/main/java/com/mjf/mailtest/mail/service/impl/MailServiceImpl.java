package com.mjf.mailtest.mail.service.impl;

import com.mjf.mailtest.mail.service.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mjf
 * @version 1.0
 * @date 2021/11/25 21:25
 */

@Service
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.username}")
    private String sender;

    @Resource
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo("1326878719@qq.com");
        message.setSubject("主题：测试");
        message.setText("内容：测试内容");
        mailSender.send(message);
    }
}