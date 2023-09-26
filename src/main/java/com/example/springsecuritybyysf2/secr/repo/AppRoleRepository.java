package com.example.springsecuritybyysf2.secr.repo;

import com.example.springsecuritybyysf2.secr.etities.AppRole;
import com.example.springsecuritybyysf2.secr.etities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
