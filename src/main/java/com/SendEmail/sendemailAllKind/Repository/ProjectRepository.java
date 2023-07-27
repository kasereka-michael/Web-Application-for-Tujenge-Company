package com.SendEmail.sendemailAllKind.Repository;

import com.SendEmail.sendemailAllKind.domain.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Projects,Long> {
    List<Projects> findByOwner(String owner);
    List<Projects> findByStatus(Boolean status);
    long count();
}
