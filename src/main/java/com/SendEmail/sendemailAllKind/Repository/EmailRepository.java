package com.SendEmail.sendemailAllKind.Repository;

import com.SendEmail.sendemailAllKind.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long> {
    Email findByEmailIgnoreCase(String email);
    Email existsByEmail(String email);
    long count();
}
