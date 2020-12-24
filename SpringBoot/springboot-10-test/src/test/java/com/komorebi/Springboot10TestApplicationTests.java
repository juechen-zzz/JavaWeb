package com.komorebi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot10TestApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    // 简单邮件
    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("nihao~");
        mailMessage.setText("123123");
        mailMessage.setTo("240553516@qq.com");
        mailMessage.setFrom("nihaopeng1997@126.com");

        mailSender.send(mailMessage);
    }

    // 复杂邮件
    @Test
    void contextLoads2() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        // 组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
        helper.setSubject("nihao2~");
        helper.setText("<p style='color:red'>321321</p>", true);

        // 附件
        helper.addAttachment("dog.jpg", new File("/Users/nihaopeng/Pictures/DynamicWallpaperClub壁纸/dog.jpg"));

        helper.setTo("240553516@qq.com");
        helper.setFrom("nihaopeng1997@126.com");

        mailSender.send(mimeMessage);
    }
}
