package store.product.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.product.management.models.Client;
import store.product.management.models.Sale;
import store.product.management.service.ClientsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
public class ClientsController {
    @Autowired
    ClientsService clientsService;


    @GetMapping("fetch")
    public ResponseEntity<List<Client>> fetchClients() {

        try {

            return new ResponseEntity<>(clientsService.fetchClients(), HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
        return null;
    }

    @GetMapping("fetch/id:{id}")
    public ResponseEntity<Client> fetchClientById(@PathVariable UUID id) {

        try {

            return new ResponseEntity<>(clientsService.findClientById(id), HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
        return null;
    }

    @GetMapping("fetch-sales/id:{id}")
    public ResponseEntity<List<Sale>> fetchClientSales(@PathVariable UUID id) {

        try {

            return new ResponseEntity<>(clientsService.fetchClientSales(id), HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
        return null;
    }

    @PostMapping("insert")
    public ResponseEntity<Client> insertNewClient(@RequestBody Client client) {

        try {

            return new ResponseEntity<>(clientsService.addNewClient(client), HttpStatus.CREATED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
        return null;
    }

    @PutMapping("update/id:{id}")
    public ResponseEntity<Client> updateClient(@PathVariable UUID id, @RequestBody Client client) {

        try {

            return new ResponseEntity<>(clientsService.updateClient(id, client), HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
        return null;
    }

    @DeleteMapping("delete/id:{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable UUID id) {

        try {

            return new ResponseEntity<>(clientsService.deleteClient(id), HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
        return null;
    }
}
