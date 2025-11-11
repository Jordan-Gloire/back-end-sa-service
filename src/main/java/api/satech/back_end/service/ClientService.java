package api.satech.back_end.service;

import java.util.List;
import java.util.Optional;

// import api.satech.back_end.entites.Client;
import org.springframework.stereotype.Service;

import api.satech.back_end.entites.Client;
import api.satech.back_end.repository.ClientRepository;

@Service
public class ClientService {

    // private ClientRepository clientRepository;
    // public ClientService(ClientRepository clientRepository){
    // this.clientRepository = clientRepository;
    // }

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(Client client) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(client.getEmail());
        if (clientDansLaBDD != null) {
            throw new IllegalArgumentException("Un client avec cet email existe déjà.");
        }
        this.clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isPresent()){
            return optionalClient.get();
        }
        return null;
    }

}