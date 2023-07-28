package com.SendEmail.sendemailAllKind.Service.ImpService;

import com.SendEmail.sendemailAllKind.Repository.EmailRepository;
import com.SendEmail.sendemailAllKind.Service.Email_Service;
import com.SendEmail.sendemailAllKind.Utils.EmailUtils;
import com.SendEmail.sendemailAllKind.domain.Email;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.BodyPart;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static com.SendEmail.sendemailAllKind.Utils.EmailUtils.ViewTheUplaodedFile;
import static com.SendEmail.sendemailAllKind.Utils.EmailUtils.getVerificationUrl;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImp implements Email_Service  {
    public static final String NEW_PROJECT = "Message for your project";
    public static final String NEW_FILE_UPLOAD ="Tujenge uploaded a New file";
    public static final String UTF_8_ENCODING = "UTF-8";
    public static final String EMAIL_TEMPLATE = "emailTemplate";
    public static final String TEXT_HTML_ENCODING = "text/html";
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
    private final EmailRepository emailRepository;
    @Value("${spring.properties.mail.mine.smtp.verify.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String fromEmail;




    @Override
    @Async
    public void sendSimpleNewProjectMailMessage(String name, String to, String project_title, LocalDateTime dateTime) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(NEW_PROJECT);
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setText(EmailUtils.getEMailNewProjectMessage(name,project_title,dateTime));
            mailSender.send(message);
        }catch(Exception exception){
            System.out.print("the error is here "+exception.getMessage());
            throw new RuntimeException("the error "+exception.getMessage());
        }

    }

    @Override
    @Async
    public void sendMineMessageWithAttachment(String name, String to, String token) {
        try{

            MimeMessage message = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
//            helper.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setText(EmailUtils.getEMailMessage(name,host,token));
//            add attachment
            FileSystemResource pdf = new FileSystemResource(new File(System.getProperty("user.home") +"/Downloads/KING.jpg"));
//            FileSystemResource michael_pic = new FileSystemResource(new File(System.getProperty());


            helper.addAttachment( pdf.getFilename(),  pdf);



            mailSender.send(message);

        }catch(Exception exception){
            System.out.print("the error is here "+exception.getMessage());
            throw new RuntimeException("the error "+exception.getMessage());
        }

    }

    @Override
    @Async
    public void sendSimpleMailMessageWithEmbeddedFiles(String name, String to, String token) {

        try{

            MimeMessage message = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
//            helper.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setText(EmailUtils.getEMailMessage(name,host,token));
//            add attachment
            FileSystemResource pdf = new FileSystemResource(new File(System.getProperty("user.home") +"/Downloads/KING.jpg"));
//            FileSystemResource michael_pic = new FileSystemResource(new File(System.getProperty());

//          the only change
            // however for this only images can go to the in boby of the email for other kind of files i dont know yet
            helper.addInline(getContentId(pdf.getFilename()),  pdf);



            mailSender.send(message);

        }catch(Exception exception){
            System.out.print("the error is here "+exception.getMessage());
            throw new RuntimeException("the error "+exception.getMessage());
        }

    }

    @Override
    @Async
    public void sendSimpleMailMessageWithEmbeddedImages(String name, String to, String token) {
        try{

            MimeMessage message = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
//            helper.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setText(EmailUtils.getEMailMessage(name,host,token));
//            add attachment
            FileSystemResource pdf = new FileSystemResource(new File(System.getProperty("user.home") +"/Downloads/KING.jpg"));
//            FileSystemResource michael_pic = new FileSystemResource(new File(System.getProperty());
//
//          the only change
            helper.addInline(getContentId(pdf.getFilename()),  pdf);



            mailSender.send(message);

        }catch(Exception exception){
            System.out.print("the error is here "+exception.getMessage());
            throw new RuntimeException("the error "+exception.getMessage());
        }

    }

    @Override
    @Async
    public void sendSimpleHtmlEmail(String name, String to, String token) {
        try{
            Context context = new Context();
//            context.setVariable("name", name);
//            context.setVariable("url", getVerificationUrl(host, token));
            context.setVariables(Map.of("name", name,"url", getVerificationUrl(host, token)));
            String text = templateEngine.process(EMAIL_TEMPLATE, context);
            MimeMessage message = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
//            helper.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setText(text, true);
//            FileSystemResource pdf = new FileSystemResource(new File(System.getProperty("user.home") +"/Downloads/KING.jpg"));
//            helper.addInline(getContentId(pdf.getFilename()),  pdf);

            mailSender.send(message);

        }catch(Exception exception){
            System.out.print("the error is here "+exception.getMessage());
            throw new RuntimeException("the error "+exception.getMessage());
        }

    }



    @Override
    @Async
    public void sendSimpleHtmlEmailWithEmbeddedFile(String name, String to, String token) {
        try{

            MimeMessage message = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
            helper.setPriority(1);
//            helper.setSubject(NEW_USER_ACCOUNT_VERIFICATION);
            helper.setFrom(fromEmail);
            helper.setTo(to);
//            helper.setText(text, true);
            Context context = new Context();
            context.setVariables(Map.of("name", name,"url", getVerificationUrl(host, token)));

//            add html eamil body
            String text = templateEngine.process(EMAIL_TEMPLATE, context);
            MimeMultipart mimeMultipart = new MimeMultipart( "related");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(text,TEXT_HTML_ENCODING);
            mimeMultipart.addBodyPart(messageBodyPart);

//            add image to the email body
            BodyPart imageBodyPart = new MimeBodyPart();
            DataSource datasource = new FileDataSource(System.getProperty("user.home") +"/Downloads/KING.jpg");


            imageBodyPart.setDataHandler(new DataHandler(datasource));
            imageBodyPart.setHeader("Content-ID","image");
            mimeMultipart.addBodyPart(imageBodyPart);

//            adding content and file in to the message
            message.setContent(mimeMultipart);



            mailSender.send(message);

        }catch(Exception exception){
            System.out.print("the error is here "+exception.getMessage());
            throw new RuntimeException("the error "+exception.getMessage());
        }
    }

    @Override
    @Async
    public void sendHtmlEmailToAllSubscribers(List<Email> toList,String api,String path) {
        try{

            MimeMessage message = getMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, UTF_8_ENCODING);
            helper.setPriority(1);
            helper.setSubject(NEW_FILE_UPLOAD);
            helper.setFrom(fromEmail);
            String[] recipients = toList.stream().map(Email::getEmail).toArray(String[]::new);
            helper.setTo(recipients);


            Context context = new Context();
            context.setVariables(Map.of("url", ViewTheUplaodedFile(host,api)));

//            add html email body
            String text = templateEngine.process(EMAIL_TEMPLATE, context);
            MimeMultipart mimeMultipart = new MimeMultipart( "related");
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(text,TEXT_HTML_ENCODING);
            mimeMultipart.addBodyPart(messageBodyPart);
            log.info("the file path in the email service "+ path);
//            add image to the email body
            BodyPart imageBodyPart = new MimeBodyPart();
            DataSource datasource = new FileDataSource(path);



            imageBodyPart.setDataHandler(new DataHandler(datasource));
            imageBodyPart.setHeader("Content-ID","image");
            mimeMultipart.addBodyPart(imageBodyPart);

//            adding content and file in to the message
            message.setContent(mimeMultipart);



            mailSender.send(message);

        }catch(Exception exception){
            System.out.print("the error is here "+exception.getMessage());
            throw new RuntimeException("the error "+exception.getMessage());
        }
    }



    @Override
    public List<Email> allSubscribers() {
        return emailRepository.findAll();
    }

    private MimeMessage getMimeMessage(){

        return mailSender.createMimeMessage();
    }

    private String getContentId(String filename){

        return "<"+ filename +">";
    }
}
