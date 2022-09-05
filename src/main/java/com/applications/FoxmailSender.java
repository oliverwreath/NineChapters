package com.applications;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by yanli_000 on 16/7/5.
 */
@Slf4j
class FoxmailSender implements MailSenderApi {
  private Message foxmailMessage;
  private final String username;
  private final String password;

  public FoxmailSender(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public void sendMail(String toRecipient) {
    try {
      Message message = getMailMessage();
      message.setRecipients(Message.RecipientType.TO,
              InternetAddress.parse(toRecipient));
      message.setSubject("地上鞋两双！");
      message.setText("头先个黍米好难食");

      Transport.send(message);

      log.debug(SENT_SUCCESS);
    } catch (Exception e) {
      log.error(Throwables.getStackTraceAsString(e));
    }
  }

  @Override
  public Message getMailMessage() {
    if (foxmailMessage == null) {
      Properties properties = new Properties();
      properties.put(MAIL_SMTP_STARTTLS_ENABLE, "true");
      properties.put(MAIL_SMTP_AUTH, "true");
      properties.put(MAIL_SMTP_HOST, "smtp.qq.com");
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

      foxmailMessage = message;
    }
    return foxmailMessage;
  }
}
