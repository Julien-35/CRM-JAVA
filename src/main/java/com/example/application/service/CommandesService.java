package com.example.application.services;

import com.example.application.entities.Commandes;
import com.example.application.repositories.CommandesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandesService {

    private final CommandesRepository commandesRepository;

    // Injection du repository via le constructeur
    public CommandesService(CommandesRepository commandesRepository) {
        this.commandesRepository = commandesRepository;
    }

    //  Récupérer toutes les commandes
    public List<Commandes> getAllCommandes() { // Correction du nom
        return commandesRepository.findAll();
    }

    //  Récupérer une commande par ID (avec gestion d'erreur si non trouvée)
    public Commandes getCommandesById(Long id) {
        return commandesRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Commande non trouvée avec l'ID : " + id));
    }

    //  Créer une nouvelle commande (avec validation du client)
    public Commandes createCommandes(Commandes commandes) {
        if (commandes.getClient() == null || commandes.getClient().getId() == null) {
            throw new IllegalArgumentException("Le client est obligatoire pour une commande.");
        }
        return commandesRepository.save(commandes);
    }

    //  Mettre à jour une commande existante
    public Commandes updateCommandes(Long id, Commandes commandes) {
        if (!commandesRepository.existsById(id)) {
            throw new EntityNotFoundException("Commande non trouvée avec l'ID : " + id);
        }
        commandes.setIdCommandes(id); // S'assurer que l'ID est correct
        return commandesRepository.save(commandes);
    }

    //  Supprimer une commande par ID
    public boolean deleteCommandes(Long id) {
        if (!commandesRepository.existsById(id)) {
            throw new EntityNotFoundException("Commande non trouvée avec l'ID : " + id);
        }
        commandesRepository.deleteById(id);
        return true;
    }
}
