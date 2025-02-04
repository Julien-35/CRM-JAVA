package com.example.application.services;

import com.example.application.entities.Client;
import com.example.application.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    // Constructeur pour injecter le ClientRepository
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Récupérer tous les clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Récupérer un client par ID
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null); // Renvoie null si le client n'existe pas
    }

    // Créer un nouveau client
    public Client createClient(Client client) {
        return clientRepository.save(client); // Sauvegarde le client dans la base de données
    }

    // Mettre à jour un client existant
    public Client updateClient(Long id, Client client) {
        if (clientRepository.existsById(id)) {
            client.setId(id); // Assure que l'ID est correct
            return clientRepository.save(client); // Met à jour le client
        }
        return null; // Si le client n'existe pas
    }

    // Supprimer un client par ID
    public boolean deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id); // Supprime le client
            return true; // Suppression réussie
        }
        return false; // Si le client n'existe pas
    }
}
