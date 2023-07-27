package com.SendEmail.sendemailAllKind.Service.FileServices;

import com.SendEmail.sendemailAllKind.Repository.FileRepository;
import com.SendEmail.sendemailAllKind.Service.FileService;
import com.SendEmail.sendemailAllKind.domain.Upload_file;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileServiceImp implements FileService {
    private final FileRepository fileRepository;
    @Override
    public Boolean uploadFile(Upload_file uploadFile) {
        fileRepository.save(uploadFile);
        return Boolean.TRUE;
    }
}
