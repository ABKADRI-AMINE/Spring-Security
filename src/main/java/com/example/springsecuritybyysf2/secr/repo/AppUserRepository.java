package com.example.springsecuritybyysf2.secr.repo;

import com.example.springsecuritybyysf2.secr.etities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
