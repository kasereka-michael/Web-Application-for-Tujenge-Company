package com.SendEmail.sendemailAllKind.Repository;

import com.SendEmail.sendemailAllKind.domain.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ToolRepository extends JpaRepository<Tools,Long> {
    long count();
    List<Tools> findAllByToolname(String name);
}
