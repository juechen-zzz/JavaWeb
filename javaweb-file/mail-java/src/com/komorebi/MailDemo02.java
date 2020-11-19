package com.komorebi;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

// 正常邮件：邮件正文带图片
public class MailDemo02 {
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
        message.setSubject("正文带图片的正常邮件");

        // 4.1 准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource("/Users/nihaopeng/个人/Git/JavaWeb/javaweb-file/mail-java/src/resources/dog_and_cat.jpeg"));    // 图片需要处理
        image.setDataHandler(dh);                   // 在body中放入这个处理的图片数据
        image.setContentID("dog_and_cat.jpeg");     // 给图片设置一个ID，这样在后面可以使用
        
        // 4.2 准备正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这是一封邮件正文带图片<img src='cid:dog_and_cat.jpeg'>的邮件", "text/html;charset=UTF-8");  // cid：ContentID

        // 4.3 描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related");

        // 4.4 设置到消息中，保存修改
        message.setContent(mm);
        message.saveChanges();

        // 5. 发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }
}
