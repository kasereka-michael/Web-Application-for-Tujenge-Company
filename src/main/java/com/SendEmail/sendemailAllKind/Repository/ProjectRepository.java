package com.SendEmail.sendemailAllKind.Repository;

import com.SendEmail.sendemailAllKind.domain.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Projects,Long> {
    List<Projects> findByOwner(String owner);
    List<Projects> existsByStatus(Boolean status);

}
