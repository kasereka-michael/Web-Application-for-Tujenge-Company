package com.SendEmail.sendemailAllKind.Service;

import com.SendEmail.sendemailAllKind.domain.Projects;
import java.util.List;

public interface ProjectService {
    List<Projects> getProjectOwner(String name);
    List<Projects> getProjectStatus(Boolean status);

    Boolean saveProject(Projects projects);
}
