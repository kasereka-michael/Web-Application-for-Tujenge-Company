package com.SendEmail.sendemailAllKind.Repository;

import com.SendEmail.sendemailAllKind.domain.Upload_file;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<Upload_file,Long> {

}
