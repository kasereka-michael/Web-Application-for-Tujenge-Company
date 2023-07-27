package com.SendEmail.sendemailAllKind.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Members member;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Projects project;
    @Column(unique = true)
    private String email;
}
