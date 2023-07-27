package com.SendEmail.sendemailAllKind.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private byte[] file;
}
