package com.example.application.repositories;

import com.example.application.entities.Document; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    // Méthodes personnalisées de recherche peuvent être ajoutées ici si nécessaire
}
