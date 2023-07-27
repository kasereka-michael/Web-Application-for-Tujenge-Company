package com.SendEmail.sendemailAllKind.Service.ToolServices;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.SendEmail.sendemailAllKind.Repository.ToolRepository;
import com.SendEmail.sendemailAllKind.Service.ToolService;
import com.SendEmail.sendemailAllKind.domain.Tools;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToolServiceImp implements ToolService {

    private final ToolRepository toolRepository;

    @Override
    public long totalTools() {
        return toolRepository.count();
    }

    @Override
    public List<Tools> findToolByToolName(String toolname) {
        List<Tools> toolsList = toolRepository.findAllByToolname(toolname);
        if(toolsList == null)
            throw new RuntimeException("No such tool with name "+ toolname);
        return toolsList;
    }


    @Override
    public Boolean saveTool(Tools tools) {
        toolRepository.save(tools);
        return Boolean.TRUE;
    }
}
