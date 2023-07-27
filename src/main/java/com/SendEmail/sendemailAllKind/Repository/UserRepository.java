package com.SendEmail.sendemailAllKind.Repository;

import com.SendEmail.sendemailAllKind.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
    boolean existsById(Long id);
}
