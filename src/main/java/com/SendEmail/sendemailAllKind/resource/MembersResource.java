package com.SendEmail.sendemailAllKind.resource;

import com.SendEmail.sendemailAllKind.Service.MembersServiceImp.MemberServiceImplement;
import com.SendEmail.sendemailAllKind.domain.Members;
import com.SendEmail.sendemailAllKind.domain.Projects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MembersResource {
    private final MemberServiceImplement memberServiceImplement;
    public static final String DATA_CHECKING = "Please check you input information";

    @PostMapping("/savemember")
    public String saveMembers(@ModelAttribute("member") Members members, Model model){

        //TODO handle notwork loss
        Boolean saveCheck = memberServiceImplement.saveMember(members);
        if(!saveCheck) {
            model.addAttribute("inputError", DATA_CHECKING);
            model.addAttribute("project",members);
            log.info("problem in the controller while attempting to save members");
            return "redirect:/api/admin/dashboard";
        }
        model.addAttribute("project",new Members());
        model.addAttribute("successPop","block");
        log.info("data saved successfully in the controller");
        return "redirect:/api/admin/dashboard";

    }

}
