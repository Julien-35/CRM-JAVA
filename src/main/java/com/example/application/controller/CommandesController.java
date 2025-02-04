package com.example.application.controllers;

import com.example.application.entities.Commandes;
import com.example.application.services.CommandesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes") // URL de base pour les commandes
public class CommandesController {

    private final CommandesService commandesService;

    public CommandesController(CommandesService commandesService) {
        this.commandesService = commandesService;
    }

    //  Récupérer toutes les commandes
    @GetMapping
    public ResponseEntity<List<Commandes>> getAllCommandes() {
        List<Commandes> commandes = commandesService.getAllCommandes(); // Correction du nom
        return ResponseEntity.ok(commandes);
    }

    //  Récupérer une commande par ID (gestion des erreurs intégrée)
    @GetMapping("/{id}")
    public ResponseEntity<Commandes> getCommandesById(@PathVariable Long id) {
        Commandes commandes = commandesService.getCommandesById(id);
        return ResponseEntity.ok(commandes); // Plus besoin du if, l'exception gère les erreurs
    }

    //  Créer une nouvelle commande
    @PostMapping
    public ResponseEntity<Commandes> createCommandes(@RequestBody Commandes commandes) {
        Commandes createdCommandes = commandesService.createCommandes(commandes);
        return new ResponseEntity<>(createdCommandes, HttpStatus.CREATED);
    }

    //  Mettre à jour une commande existante
    @PutMapping("/{id}")
    public ResponseEntity<Commandes> updateCommandes(@PathVariable Long id, @RequestBody Commandes commandes) {
        Commandes updatedCommandes = commandesService.updateCommandes(id, commandes);
        return ResponseEntity.ok(updatedCommandes);
    }

    //  Supprimer une commande par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommandes(@PathVariable Long id) {
        commandesService.deleteCommandes(id); // L'exception gère si l'ID n'existe pas
        return ResponseEntity.noContent().build();
    }
}
