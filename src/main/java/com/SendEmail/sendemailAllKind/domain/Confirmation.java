package com.SendEmail.sendemailAllKind.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="Confirmations")
public class Confirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private LocalDateTime createdDate;
    @OneToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private Users users;

     public Confirmation(Users users){
         this.users = users;
         this.createdDate = LocalDateTime.now();
         this.token = UUID.randomUUID().toString();
     }

}
