package com.SendEmail.sendemailAllKind.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

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
    @CreatedDate
    private LocalDateTime dateTime;
    private String duration;
    private String location;
    private Boolean status;
    //mappedby signale the that the actual class is not the owner or parent
    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<Members> members;
}
