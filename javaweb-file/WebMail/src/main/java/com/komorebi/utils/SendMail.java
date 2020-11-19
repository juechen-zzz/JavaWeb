package com.komorebi.utils;

import com.komorebi.pojo.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

// 网站3秒原则：用户体验
// 多线程实现用户体验！   异步处理
public class SendMail extends Thread {
    private String from = "nihaopeng1997@126.com";
    private String username = "nihaopeng1997@126.com";
    private String password = "EETBDIXTIBOQXYYA";
    private String host = "smtp.126.com";

    private User user;
    public SendMail(User user){
        this.user = user;
    }

    @Override
    public void run() {
        try{
            Properties prop = new Properties();
            prop.setProperty("mail.host", host);
            prop.setProperty("mail.transport.protocol", "smtp");
            prop.setProperty("mail.smtp.auth", "true");

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
            ts.connect(host, username, password);

            // 4. 创建邮件
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setSubject("用户注册邮件");
            String info = "username: " + user.getUsername() + ", password: " + user.getPassword();
            message.setContent(info, "text/html;charset=UTF-8");
            message.saveChanges();

            // 5. 发送邮件
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
