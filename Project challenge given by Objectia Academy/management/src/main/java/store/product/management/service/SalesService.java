package store.product.management.service;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.product.management.models.Client;
import store.product.management.models.Product;
import store.product.management.models.Sale;
import store.product.management.repositories.ClientsRepository;
import store.product.management.repositories.ProductsRepository;
import store.product.management.repositories.SalesRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SalesService {
    @Autowired
    SalesRepository salesRepository;
    @Autowired
    ClientsRepository clientsRepository;
    @Autowired
    ProductsRepository productsRepository;



    public List<Sale> fetchSales() throws Exception {
        List<Sale> saleList = salesRepository.findAll();

        if (saleList.size() > 0)
            return saleList;
        else
            throw new Exception("No Sales Found.");
    }

    public Sale fetchSaleById(UUID id) throws Exception {
        Optional<Sale> sale = salesRepository.findById(id);

        if (sale.isPresent())
            return sale.get();
        else
            throw new Exception("Sale Id does not exist.");
    }

    public Sale insertNewSale(Sale sale) throws Exception {
        Optional<Client> client = clientsRepository.findById(sale.getClient().getClient_id());
        Optional<Product> product = productsRepository.findById(sale.getProduct().getProduct_id());

        if (client.isPresent() && product.isPresent()) {
            Sale savedSale = salesRepository.save(sale);

            return savedSale;
        }
        else
            throw new Exception("Non-existent client or product ID.");
    }

    public Sale updateSale(UUID ID, Sale sale) throws Exception {
        Optional<Client> client = clientsRepository.findById(sale.getClient().getClient_id());
        Optional<Product> product = productsRepository.findById(sale.getProduct().getProduct_id());

        if (client.isPresent() && product.isPresent()) {
            Sale newSale = new Sale();

            newSale.setSaleId(ID);
            newSale.setClient(sale.getClient());
            newSale.setProduct(sale.getProduct());
            newSale.setTotalPrice(sale.getTotalPrice());
            newSale.setCreationDate(sale.getCreationDate());

            return newSale;
        }
        else
            throw new Exception("Non-existent client or product ID.");
    }

    public Sale deleteSale(UUID id) throws Exception {
        Optional<Sale> sale = salesRepository.findById(id);

        if (sale.isPresent())
            salesRepository.delete(sale.get());
        else
            throw new Exception("Sales ID does not exist.");
        return null;
    }
}
