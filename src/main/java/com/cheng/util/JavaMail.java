package com.cheng.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Configuration
public class JavaMail {
    @Resource
    JavaMailSenderImpl javaMailSender;


    public void mail(Boolean html,String to,String text,String title) throws MessagingException {
        MimeMessage mimeMailMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMailMessage,html);
        helper.setText(text,true);
        helper.setSubject(title);

        helper.setFrom("1720730700@qq.com");
        helper.setTo(to);


        javaMailSender.send(mimeMailMessage);

    }
}
