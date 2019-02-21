package com.applications;

import javax.mail.*;
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
    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    public static void main(String[] args) {
        sendFromCRM();
    }

    private static void sendFoxmail() {
        try {
            Message foxmailMessage = getFoxmailMessage();
            foxmailMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("199383447@qq.com"));
            foxmailMessage.setSubject("地上鞋两双！");
            foxmailMessage.setText("头先个黍米好难食");

            Transport.send(foxmailMessage);

            System.out.println("Sent and Done!");
        } catch (Exception e) {
            logger.error(Throwables.getStackTraceAsString(e));
        }
    }

    private static void sendGmail() {
        try {
            Message gmailMessage = getGmailMessage();
            gmailMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("199383447@qq.com"));
            gmailMessage.setSubject("Testing Subject");
            gmailMessage.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(gmailMessage);

            System.out.println("Sent and Done!");
        } catch (Exception e) {
            logger.error(Throwables.getStackTraceAsString(e));
        }
    }

    private static void sendFromCRM() {
        try {
            Message gmailCRMMessage = getGmailCRMMessage();
            gmailCRMMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("skywalkerhunter@gmail.com"));
            gmailCRMMessage.setSubject("Testing Subject");
            gmailCRMMessage.setText("hello");

            Transport.send(gmailCRMMessage);

            System.out.println("Sent and Done!");
        } catch (Exception e) {
            logger.error(Throwables.getStackTraceAsString(e));
        }
    }

    private static Message getFoxmailMessage() {
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
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(USER_NAME));
        } catch (MessagingException e) {
            logger.error(Throwables.getStackTraceAsString(e));
        }

        return message;
    }

    private static Message getGmailMessage() {
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
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(USER_NAME));
        } catch (MessagingException e) {
            logger.error(Throwables.getStackTraceAsString(e));
        }

        return message;
    }

    private static Message getGmailCRMMessage() {
        final String USER_NAME = "crmtransformed@gmail.com";
        final String PASSWORD = "QLRk5D7gesCgQhj";

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
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(USER_NAME));
        } catch (MessagingException e) {
            logger.error(Throwables.getStackTraceAsString(e));
        }

        return message;
    }
}