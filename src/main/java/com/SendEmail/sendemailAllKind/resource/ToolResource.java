package com.SendEmail.sendemailAllKind.resource;


import com.SendEmail.sendemailAllKind.Service.ToolServices.ToolServiceImp;
import com.SendEmail.sendemailAllKind.domain.Tools;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ToolResource {

    private final ToolServiceImp toolServiceImp;

    @PostMapping("/saveTool")
    public String saveTools(@ModelAttribute("tool") Tools tools, Model model){
                 toolServiceImp.saveTool(tools);
                 log.info("tool saved successfully");
        return "redirect:/api/admin/dashboard";
    }

}


