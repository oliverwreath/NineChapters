package com.applications;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli_000 on 16/7/5.
 */

class MailSender {
    private final static Logger logger = LoggerFactory.getLogger(MailSender.class);

    public static void main(String[] args) {
        sendFoxmail();
    }

    private static void sendFoxmail() {
        final String USER_NAME = "skyoliver@foxmail.com";
        final String PASSWORD = "+++hyl7713996";

        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.qq.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USER_NAME, PASSWORD);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USER_NAME));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("199383447@qq.com"));
            message.setSubject("床前明月光！");
            message.setText("头先个黍米好难食");

            Transport.send(message);

            System.out.println("Sent and Done!");
        } catch (Exception e) {
            logger.error(Throwables.getStackTraceAsString(e));
        }
    }

    private static void sendGmail() {
        final String USER_NAME = "skywalkerhunter@gmail.com";
        final String PASSWORD = "+++hyl7713996";

        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(USER_NAME, PASSWORD);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USER_NAME));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("199383447@qq.com"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Sent and Done!");
        } catch (Exception e) {
            logger.error(Throwables.getStackTraceAsString(e));
        }
    }
}