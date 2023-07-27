package com.SendEmail.sendemailAllKind.Repository;

import com.SendEmail.sendemailAllKind.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Long> {

}
