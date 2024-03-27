package store.product.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.product.management.models.Client;
import store.product.management.models.Sale;
import store.product.management.repositories.ClientsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientsService {
    @Autowired
    ClientsRepository clientsRepository;


    public List<Client> fetchClients() throws Exception {
        List<Client> clientList = clientsRepository.findAll();

        if (clientList.size() > 0)
            return clientList;
        else
            throw new Exception("No Client Found.");
    }

    public Client findClientById(UUID id) throws Exception {
        Optional<Client> client = clientsRepository.findById(id);

        if (client.isPresent())
            return client.get();
        else
            throw new Exception("Client Not Found.");
    }

    public List<Sale> fetchClientSales(UUID id) throws Exception {
        Optional<Client> client = clientsRepository.findById(id);

        if (client.isPresent())
            return client.get().getSales();
        else
            throw new Exception("Client Not Found.");
    }

    public Client addNewClient(Client client) {

        return clientsRepository.save(client);
    }

    public Client updateClient(UUID id, Client client) throws Exception {
        Optional<Client> option = clientsRepository.findById(id);

        if (option.isPresent()) {
            Client client1 = new Client();

            client1.setClient_id(id);
            client1.setFirstName(client.getFirstName());
            client1.setLastName(client.getLastName());
            client1.setMobile(client.getMobile());
            client1.setSales(client.getSales());

            return clientsRepository.save(client1);
        } else {

            throw new Exception("Client ID Not Found.");
        }
    }

    public Client deleteClient(UUID id) throws Exception {
        Optional<Client> option = clientsRepository.findById(id);

        if (option.isPresent())
            clientsRepository.delete(option.get());
        else
            throw new Exception("Client ID Not Found.");

        return null;
    }
}
