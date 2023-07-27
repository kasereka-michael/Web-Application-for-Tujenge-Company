package com.SendEmail.sendemailAllKind.Service.ProjectServiceImp;

import com.SendEmail.sendemailAllKind.Repository.ProjectRepository;
import com.SendEmail.sendemailAllKind.Service.Email_Service;
import com.SendEmail.sendemailAllKind.Service.NormalSMSImp.NormalSmsImplement;
import com.SendEmail.sendemailAllKind.Service.ProjectService;
import com.SendEmail.sendemailAllKind.domain.Projects;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProjectServiceImplement implements ProjectService {

    private final ProjectRepository projectRepository;
    private final Email_Service emailService;
    private final NormalSmsImplement smsImplement;

    @Override
    public List<Projects> getProjectOwner(String name) {
        List<Projects> projects = projectRepository.findByOwner(name);

        if(projects.isEmpty())
            return new ArrayList<>();
        return projects;
    }

    @Override
    public List<Projects> getProjectStatus(Boolean status) {
        List<Projects> Allproject = projectRepository.findByStatus(status);

        if(Allproject.isEmpty())
            return new ArrayList<>();
        return Allproject;
    }

    @Override
    public Boolean saveProject(Projects projects) {
        Boolean result = false;
        projectRepository.save(projects);
        emailService.sendSimpleNewProjectMailMessage(projects.getOwner(),projects.getEmail().getEmail(),projects.getTitle(),projects.getDateTime());
        smsImplement.sendMessageToProjectOwner(projects.getOwnerPhone(),projects.getOwner(),projects.getTitle());
        result = true;

        return result;
    }


}
