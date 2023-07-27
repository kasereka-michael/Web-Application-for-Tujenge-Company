package com.SendEmail.sendemailAllKind.resource;


import com.SendEmail.sendemailAllKind.Service.FileServices.FileServiceImp;
import com.SendEmail.sendemailAllKind.domain.Upload_file;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
@Slf4j
public class FileResources {

    private final FileServiceImp fileServiceImp;
    @PostMapping("/savefile")
    public String saveUploadedFile(@ModelAttribute("files") Upload_file upload_File, Model model){
        fileServiceImp.uploadFile(upload_File);
       return "redirect:/api/admin/dashboard";
    }
}
