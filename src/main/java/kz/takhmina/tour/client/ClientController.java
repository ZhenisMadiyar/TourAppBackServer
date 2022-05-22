package kz.takhmina.tour.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public List<Client> clients() {
        return clientService.getClientList();
    }

    @PostMapping
    public void createClient(@RequestBody Client client) {
        clientService.createClient(client);
    }

}