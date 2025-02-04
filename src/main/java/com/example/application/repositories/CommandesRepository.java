package com.example.application.repositories;

import com.example.application.entities.Commandes; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandesRepository extends JpaRepository<Commandes, Long> {
    // Méthodes personnalisées de recherche peuvent être ajoutées ici si nécessaire
}
