package com.SendEmail.sendemailAllKind.resource;

import com.SendEmail.sendemailAllKind.Service.ProjectServiceImp.ProjectServiceImplement;
import com.SendEmail.sendemailAllKind.domain.Projects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProjectResource {
    public static final String DATA_CHECKING = "Please check you input information";
    private final ProjectServiceImplement projectServiceImplement;


    @PostMapping("/saveproject")
    public String saveNewProject(@ModelAttribute("project")Projects projects, Model model) throws Exception{
        //TODO handle notwork loss
        Boolean saveCheck = projectServiceImplement.saveProject(projects);
        if(!saveCheck) {
            model.addAttribute("inputError", DATA_CHECKING);
            model.addAttribute("project",projects);
            log.info("problem in the controller while attempting to save project");
            return "redirect:/dashboard";
        }

        model.addAttribute("project",new Projects());
        model.addAttribute("successPop","block");
        log.info("data saved successfully in the controller");
        return "dashboard";
    }
}
