package com.example.springsecuritybyysf2.secr.service;

import com.example.springsecuritybyysf2.secr.etities.AppRole;
import com.example.springsecuritybyysf2.secr.etities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();

}
