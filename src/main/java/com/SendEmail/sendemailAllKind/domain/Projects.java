package com.SendEmail.sendemailAllKind.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String owner;
    @OneToOne(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Email email;
    private String ownerPhone;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;
    private String duration;
    private String location;
    private String siteChef;
    private byte[] projectView;
    private Boolean status;
    //mappedby signale the that the actual class is not the owner or parent
    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<Members> member;
}
