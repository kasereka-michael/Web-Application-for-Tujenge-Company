package com.SendEmail.sendemailAllKind.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String full_name;
    @Column(unique = true)
    private String email;
    private String phone;
    private byte[] picture;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "project_supervision", joinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "id"),
    },inverseJoinColumns = {@JoinColumn(name = "project_id",referencedColumnName = "id")})
    private Set<Projects> projects;

}