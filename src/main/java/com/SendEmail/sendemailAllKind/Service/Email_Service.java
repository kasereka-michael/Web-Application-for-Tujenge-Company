package com.SendEmail.sendemailAllKind.Service;

public interface Email_Service {
    void sendSimpleMailMessage(String name, String to, String token);
    void sendMineMessageWithAttachment(String name, String to, String token);
    void sendSimpleMailMessageWithEmbeddedFiles(String name, String to, String token);
    void sendSimpleMailMessageWithEmbeddedImages(String name, String to, String token);
    void sendSimpleHtmlEmail(String name, String to, String token);
    void sendSimpleHtmlEmailWithEmbeddedFile(String name, String to, String token);
}
