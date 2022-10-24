package com.applications;

import com.google.common.base.Throwables;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by yanli_000 on 16/7/5.
 */
@Slf4j
class GmailSender implements MailSenderApi {

  private Message gmailMessage;
  private final String username;
  private final String password;

  public GmailSender(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public void sendMail(String toRecipient) {
    try {
      Message message = getMailMessage();
      message.setRecipients(Message.RecipientType.TO,
          InternetAddress.parse(toRecipient));
      message.setSubject("Testing Subject");
      message.setText("Dear Mail Crawler,"
          + "\n\n No spam to my email, please!");

      Transport.send(message);

      log.info(SENT_SUCCESS);
    } catch (Exception e) {
      log.error(Throwables.getStackTraceAsString(e));
    }
  }

  @Override
  public Message getMailMessage() {
    if (gmailMessage == null) {
      Properties properties = new Properties();
      properties.put(MAIL_SMTP_STARTTLS_ENABLE, "true");
      properties.put(MAIL_SMTP_AUTH, "true");
      properties.put(MAIL_SMTP_HOST, "smtp.gmail.com");
      properties.put(MAIL_SMTP_PORT, "587");

      Session session = Session.getInstance(properties,
          new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(username, password);
            }
          });
      Message message = new MimeMessage(session);
      try {
        message.setFrom(new InternetAddress(username));
      } catch (MessagingException e) {
        log.error(Throwables.getStackTraceAsString(e));
      }

      gmailMessage = message;
    }
    return gmailMessage;
  }
}
