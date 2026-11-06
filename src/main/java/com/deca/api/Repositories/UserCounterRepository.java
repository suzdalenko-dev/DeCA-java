package com.deca.api.Repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deca.api.Models.UserCounter;

public interface UserCounterRepository extends JpaRepository<UserCounter, Long> {
    Optional<UserCounter> findFirstByOrderByIdAsc();
}
