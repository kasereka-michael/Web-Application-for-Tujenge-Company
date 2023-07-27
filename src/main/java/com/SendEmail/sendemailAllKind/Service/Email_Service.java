package com.SendEmail.sendemailAllKind.Service;

import java.time.LocalDateTime;

public interface Email_Service {
    void sendSimpleNewProjectMailMessage(String name, String to, String porject_title, LocalDateTime localDateTime);
    void sendMineMessageWithAttachment(String name, String to, String token);
    void sendSimpleMailMessageWithEmbeddedFiles(String name, String to, String token);
    void sendSimpleMailMessageWithEmbeddedImages(String name, String to, String token);
    void sendSimpleHtmlEmail(String name, String to, String token);
    void sendSimpleHtmlEmailWithEmbeddedFile(String name, String to, String token);
}
