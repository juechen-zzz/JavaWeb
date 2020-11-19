package com.komorebi;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

// 正常邮件：带附件
public class MailDemo03 {
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
        MimeMessage message = imageMail(session);

        // 5. 发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    public static MimeMessage imageMail(Session session) throws MessagingException{
        // 消息的固定信息
        MimeMessage mimeMessage = new MimeMessage(session);

        // 邮件发送人
        mimeMessage.setFrom(new InternetAddress("nihaopeng1997@126.com"));
        mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("240553516@qq.com"));
        mimeMessage.setSubject("附件带图片的正常邮件");

        /*
            编写邮件内容
                1 图片
                2 附件
                3 文本
         */

        // 图片
        MimeBodyPart image = new MimeBodyPart();
        image.setDataHandler(new DataHandler(new FileDataSource("/Users/nihaopeng/个人/Git/JavaWeb/javaweb-file/mail-java/src/resources/dog_and_cat.jpeg")));                   // 在body中放入这个处理的图片数据
        image.setContentID("dog_and_cat.jpeg");     // 给图片设置一个ID，这样在后面可以使用

        // 文本
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("这不是广告<img src='cid:dog_and_cat.jpeg'>", "text/html;charset=UTF-8");

        // 附件
        MimeBodyPart file = new MimeBodyPart();
        file.setDataHandler(new DataHandler(new FileDataSource("/Users/nihaopeng/个人/Git/JavaWeb/javaweb-file/mail-java/src/resources/hello.txt")));
        file.setFileName("hello.txt");

        // 拼装邮件正文内容
        MimeMultipart multipart1 = new MimeMultipart();
        multipart1.addBodyPart(image);
        multipart1.addBodyPart(text);
        multipart1.setSubType("related");

        // 将拼装好的正文内容设置为主体
        MimeBodyPart contentText = new MimeBodyPart();
        contentText.setContent(multipart1);

        // 拼接附件
        MimeMultipart allFile = new MimeMultipart();
        allFile.addBodyPart(file);              // 附件
        allFile.addBodyPart(contentText);       // 正文
        allFile.setSubType("mixed");

        // 放到Message消息中
        mimeMessage.setContent(allFile);
        mimeMessage.saveChanges();

        return mimeMessage;
    }
}
