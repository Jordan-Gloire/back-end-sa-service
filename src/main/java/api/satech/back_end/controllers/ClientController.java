package api.satech.back_end.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.Map;

import api.satech.back_end.entites.Client;
import api.satech.back_end.repository.ClientRepository;
import api.satech.back_end.service.ClientService;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    private ClientRepository clientRepository;
    private ClientService clientService;

    public ClientController(ClientRepository clientRepository, ClientService clientService) {
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Map<String, Object> createClient(@RequestBody Client client) {
        clientService.createClient(client);
        

        return Map.of(
                "message", "Client créé avec succès !",
                "status", "success",
                "clientEmail", client.getEmail());
    }

    // @GetMapping()
    // public List<Client> getAllClients() {
    //     return clientRepository.findAll();
    // }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping(path="{id}",produces = APPLICATION_JSON_VALUE)
    public Client getClientById(@PathVariable int id) {
        return clientService.getClientById(id);
    }
}
