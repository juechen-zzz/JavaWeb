package com.komorebi;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

// 简单邮件：没有附件和图片
public class MailDemo01 {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.126.com");          // 设置126邮箱服务器
        prop.setProperty("mail.transport.protocol", "smtp");    // 设置邮件发送协议
        prop.setProperty("mail.smtp.auth", "true");             // 需要验证用户名密码

        // 使用JavaMail发送邮件的5个步骤
        // 1. 创建定义整个应用程序所需的环境信息的Session对象
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 发件人邮件用户名和授权码
                return new PasswordAuthentication("nihaopeng1997@126.com", "EETBDIXTIBOQXYYA");
            }
        });
        session.setDebug(true);         // 开启Session的debug模式

        // 2. 通过Session得到transport对象
        Transport ts = session.getTransport();

        // 3. 使用邮箱的用户名和授权码连接服务器
        ts.connect("smtp.126.com", "nihaopeng1997@126.com", "EETBDIXTIBOQXYYA");

        // 4. 创建邮件
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("nihaopeng1997@126.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("240553516@qq.com"));
        message.setSubject("只包含文本的简单邮件");
        message.setContent("<h1 style='color: red'>你好!</h1>", "text/html;charset=UTF-8");

        // 5. 发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
}
