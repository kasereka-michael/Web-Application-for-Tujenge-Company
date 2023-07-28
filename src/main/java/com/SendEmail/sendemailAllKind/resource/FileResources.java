package com.SendEmail.sendemailAllKind.resource;


import com.SendEmail.sendemailAllKind.Service.Email_Service;
import com.SendEmail.sendemailAllKind.Service.FileServices.FileServiceImp;
import com.SendEmail.sendemailAllKind.domain.Email;
import com.SendEmail.sendemailAllKind.domain.Tools;
import com.SendEmail.sendemailAllKind.domain.Upload_file;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.SendEmail.sendemailAllKind.AdditionalOperation.OperationHolder.getTheCorrectApi;


@Controller
@RequiredArgsConstructor
@Slf4j
public class FileResources {
    private final Email_Service emailServiceImp;

    @Value("${upload.directory}")
    private String uploadDirectory;
    private final FileServiceImp fileServiceImp;
    @PostMapping("/savefile")
    public String saveUploadedFile(@Validated @RequestParam("file_field") MultipartFile multipartFile,
                                   @RequestParam("fileTitle") String filetitle,@ModelAttribute("files") Upload_file uploadFile, HttpServletRequest request, Model model, BindingResult bindingResult) throws IOException {

        if(bindingResult.hasErrors()){
            log.info("ther are many error man ");
        }
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        String filePath = uploadDirectory + filename;

        log.info("the file path: "+ filePath);

        byte[] filesdata = multipartFile.getBytes();
        multipartFile.transferTo(new File(filePath));
        uploadFile.setFile(filesdata);
        uploadFile.setFileTitle(filetitle);
        fileServiceImp.uploadFile(uploadFile);


        List<Email> subscribers = emailServiceImp.allSubscribers();
        emailServiceImp.sendHtmlEmailToAllSubscribers(subscribers,getTheCorrectApi(filetitle),filePath);
       return "redirect:/api/admin/dashboard";
    }
}
