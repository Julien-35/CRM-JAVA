package com.example.application.repositories;

import com.example.application.entities.Client; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Méthodes personnalisées de recherche peuvent être ajoutées ici si nécessaire
}
