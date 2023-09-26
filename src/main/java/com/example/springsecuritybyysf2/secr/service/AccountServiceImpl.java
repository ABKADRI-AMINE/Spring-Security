package com.example.springsecuritybyysf2.secr.service;

import com.example.springsecuritybyysf2.secr.etities.AppRole;
import com.example.springsecuritybyysf2.secr.etities.AppUser;
import com.example.springsecuritybyysf2.secr.repo.AppRoleRepository;
import com.example.springsecuritybyysf2.secr.repo.AppUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service//cette annotation permet de dire à spring que cette classe est un bean de service et donc il faut l'instancier et l'injecter dans les autres classes
@Transactional//cette annotation permet de dire à spring que toutes les méthodes de cette classe sont transactionnelles cad si une méthode échoue alors toutes les méthodes qui ont été exécutées avant cette méthode doivent être annulées
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
    }
    @Override
    public AppUser addNewUser(AppUser appUser) {
        return appUserRepository.save(appUser);//save est une méthode de l'interface JpaRepository qui permet d'ajouter un objet dans la base de données
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);//save est une méthode de l'interface JpaRepository qui permet d'ajouter un objet dans la base de données
    }

   @Override
   public void addRoleToUser(String username, String roleName) {
       AppRole appRole = appRoleRepository.findByRoleName(roleName);//findByRoleName est une méthode de l'interface AppRoleRepository qui permet de chercher un role par son roleName
       AppUser appUser = appUserRepository.findByUsername(username);//findByUsername est une méthode de l'interface AppUserRepository qui permet de chercher un user par son username
       appUser.getAppRoles().add(appRole);//getAppRoles est une méthode de la classe AppUser qui permet de récupérer la liste des roles d'un user
   }
    @Override
    public AppUser loadUserByUsername(String username) {

        return appUserRepository.findByUsername(username);//findByUsername est une méthode de l'interface AppUserRepository qui permet de chercher un user par son username
    }

    @Override
    public List<AppUser> listUsers() {

        return appUserRepository.findAll();//findAll est une méthode de l'interface JpaRepository qui permet de récupérer tous les objets d'une table
    }
}
