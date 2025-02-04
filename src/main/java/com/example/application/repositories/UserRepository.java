package com.example.application.repositories;

import com.example.application.entities.User; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Méthodes personnalisées de recherche peuvent être ajoutées ici si nécessaire
}
