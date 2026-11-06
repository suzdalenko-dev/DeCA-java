package com.deca.api.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.deca.api.Models.JavaUser;

public interface JavaUserRepository extends JpaRepository<JavaUser, Long> {
    
}
