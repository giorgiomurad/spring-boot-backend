package store.product.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.product.management.models.Product;
import store.product.management.service.ProductsService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductsService productsService;


    @GetMapping("fetch")
    public ResponseEntity<List<Product>> fetchProducts() {

        try {

            return new ResponseEntity<>(productsService.fetchProducts(), HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
        return null;
    }

    @GetMapping("fetch/id:{id}")
    public ResponseEntity<Product> fetchProductById(@PathVariable UUID id) {

        try {

            return new ResponseEntity<>(productsService.fetchProductById(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return null;
    }

    @PostMapping("insert")
    public ResponseEntity<Product> insertNewProduct(@RequestBody Product product) {

        try {

            return new ResponseEntity<>(productsService.insertNewProduct(product), HttpStatus.CREATED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
        return null;
    }

    @PutMapping("update/id:{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody Product product) {

        try {

            return new ResponseEntity<>(productsService.updateProduct(id, product), HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
        return null;
    }

    @DeleteMapping("delete/id:{id}")
    public void deleteProduct(@PathVariable UUID id) {

        try {

            productsService.deleteProduct(id);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }
    }
}
