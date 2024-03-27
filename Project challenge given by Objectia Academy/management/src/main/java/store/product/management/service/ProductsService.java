package store.product.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.product.management.models.Product;
import store.product.management.repositories.ProductsRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductsService {
    @Autowired
    ProductsRepository productsRepository;


    public Product insertNewProduct(Product product) {

        return productsRepository.save(product);
    }

    public List<Product> fetchProducts() throws Exception {
        List<Product> productList = productsRepository.findAll();

        if (productList.size() > 0)
            return productList;
        else
            throw new Exception("No Product Found.");
    }

    public Product fetchProductById(UUID id) throws Exception {
        Optional<Product> product = productsRepository.findById(id);

        if (product.isPresent())
            return product.get();
        else
            throw new Exception("Product ID Does Not Exist.");
    }

    public Product updateProduct(UUID id, Product product) throws Exception {
        Optional<Product> option = productsRepository.findById(id);

        if (option.isPresent()) {
            Product newProduct = new Product();

            newProduct.setProduct_id(id);
            newProduct.setName(product.getName());
            newProduct.setDescription(product.getDescription());
            newProduct.setCategory(product.getCategory());
            newProduct.setDoc(product.getDoc());

            return productsRepository.save(newProduct);
        }
        else
            throw new Exception("Product ID Does Not Exist.");
    }

    public void deleteProduct(UUID id) throws Exception {
        Optional<Product> product = productsRepository.findById(id);

        if (product.isPresent())
            productsRepository.delete(product.get());
        else
            throw new Exception("Product ID Does Not Exist.");
    }
}
