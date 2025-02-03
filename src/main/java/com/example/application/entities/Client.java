package com.example.application.entities; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // Indique que c'est une entité JPA
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Génère un identifiant unique
    private Long id;
    private String nom;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
