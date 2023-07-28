package com.SendEmail.sendemailAllKind.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Upload_file {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileCategory;
    private String fileTitle;
    @Column(length = 310)
    private String fileComment;
    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] file;
}
