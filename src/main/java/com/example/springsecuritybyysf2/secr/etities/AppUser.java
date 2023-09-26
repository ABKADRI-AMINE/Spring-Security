package com.example.springsecuritybyysf2.secr.etities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
@Entity// pour dire que cette classe est une entité de la base de données cad une table de la base de données
@Data// pour générer les getters et les setters
@NoArgsConstructor// pour générer le constructeur sans paramètres
@AllArgsConstructor// pour générer le constructeur avec tous les paramètres

public class AppUser {
    @Id// pour dire que c'est la clé primaire de la table
    @GeneratedValue(strategy = GenerationType.IDENTITY)// pour dire que c'est une clé primaire auto-incrémentée cad auto-générée
    private Long id;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)//fetch = FetchType.EAGER cad quand on charge un user on charge aussi ses roles
// pour dire que c'est une relation many to many cad une relation de plusieurs à plusieurs car un user peut avoir plusieurs roles et un role peut être attribué à plusieurs users
    private Collection<AppRole> AppRoles=new ArrayList<>();// Collection en java est une interface qui hérite de l'interface Iterable et qui représente un groupe d'objets dans lequel on peut ajouter ou supprimer des objets.
}
