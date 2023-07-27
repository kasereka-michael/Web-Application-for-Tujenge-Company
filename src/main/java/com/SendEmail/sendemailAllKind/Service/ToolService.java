package com.SendEmail.sendemailAllKind.Service;


import com.SendEmail.sendemailAllKind.domain.Tools;

import javax.tools.Tool;
import java.util.List;

public interface ToolService {
    long totalTools();
    List<Tools> findToolByToolName(String toolname);

    Boolean saveTool(Tools tools);


}
