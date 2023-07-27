package com.SendEmail.sendemailAllKind.Service;

import com.SendEmail.sendemailAllKind.domain.Email;

import java.time.LocalDateTime;
import java.util.List;

public interface Email_Service {
    void sendSimpleNewProjectMailMessage(String name, String to, String porject_title, LocalDateTime localDateTime);
    void sendMineMessageWithAttachment(String name, String to, String token);
    void sendSimpleMailMessageWithEmbeddedFiles(String name, String to, String token);
    void sendSimpleMailMessageWithEmbeddedImages(String name, String to, String token);
    void sendSimpleHtmlEmail(String name, String to, String token);
    void sendSimpleHtmlEmailWithEmbeddedFile(String name, String to, String token);
    public void sendHtmlEmailToAllSubscribers(List<Email> toList, String host, String messages, String api,String path);
    List<Email> allSubscribers();
}
