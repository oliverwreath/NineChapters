package com.applications;

import javax.mail.Message;

/**
 * Created by yanli_000 on 16/7/5.
 */
interface MailSenderApi {
  String SENT_SUCCESS = "Sent and Done!";
  String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
  String MAIL_SMTP_AUTH = "mail.smtp.auth";
  String MAIL_SMTP_HOST = "mail.smtp.host";
  String MAIL_SMTP_PORT = "mail.smtp.port";

  void sendMail(String toRecipient);

  Message getMailMessage();
}
