package com.SendEmail.sendemailAllKind.resource;

import com.SendEmail.sendemailAllKind.Service.ImpService.UserServiceImp;
import com.SendEmail.sendemailAllKind.domain.HttpResponse;
import com.SendEmail.sendemailAllKind.domain.Projects;
import com.SendEmail.sendemailAllKind.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class USerResource {
    private final UserServiceImp userServiceImp;



    @GetMapping("/about")
    public String openABout(){
        return "about";
    }
    @GetMapping("/ourwork")
    public String openOurWork(){
        return "ourwork";
    }
    @GetMapping("/design")
    public String openDesign(){
        return "design";
    }
    @GetMapping("/construction")
    public String openConstruction(){
        return "construction";
    }
    @GetMapping("/supervision")
    public String openSupervision(){
        return "supervision";
    }
    @GetMapping("/3dimplementation")
    public String openTroisDeux(){
        return "3dimplementation";
    }
    @GetMapping("/contact")
    public String openContact(){
        return "contact";
    }
    @GetMapping("/api/admin/dashboard")
    public String openDashboard(Model model) {
        model.addAttribute("project", new Projects());
        return "dashboard";
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpResponse> createUser(@RequestBody Users users){
    Users newUsers = userServiceImp.saveUser(users);

        return ResponseEntity.created(URI.create("")).body(
                HttpResponse.builder()

                        .timesStamp(LocalDateTime.now().toString())
                        .data(Map.of("users", newUsers))
                        .message("users created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }


    @GetMapping("/verifytoken")
    public ResponseEntity<HttpResponse> confirmUserAccount(@RequestParam("token") String token){
      Boolean result = userServiceImp.verifyToken(token);

        return ResponseEntity.ok().body(
                HttpResponse.builder()

                        .timesStamp(LocalDateTime.now().toString())
                        .data(Map.of("Success", result))
                        .message("Account Verified")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

}
