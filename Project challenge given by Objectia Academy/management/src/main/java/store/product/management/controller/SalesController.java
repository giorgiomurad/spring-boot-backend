package store.product.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import store.product.management.models.Sale;
import store.product.management.service.SalesService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    SalesService salesService;


    @GetMapping("fetch")
    public ResponseEntity<List<Sale>> fetchSales() {

        try {
            List<Sale> saleList = salesService.fetchSales();

            return new ResponseEntity<>(saleList, HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

        return null;
    }

    @GetMapping("fetch/id:{id}")
    public ResponseEntity<Sale> fetchSaleById(@PathVariable UUID id) {

        try {
            Sale sale = salesService.fetchSaleById(id);

            return new ResponseEntity<>(sale, HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

        return null;
    }

    @PostMapping("insert")
    public ResponseEntity<Sale> insertNewSale(@RequestBody Sale sale) {

        try {
            Sale sale1 = salesService.insertNewSale(sale);

            return new ResponseEntity<>(sale1, HttpStatus.CREATED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

        return null;
    }

    @PutMapping("update/id:{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable UUID id, @RequestBody Sale sale) {

        try {
            Sale updated = salesService.updateSale(id, sale);

            return new ResponseEntity<>(updated, HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

        return null;
    }

    @DeleteMapping("delete/id:{id}")
    public ResponseEntity<Sale> deleteSale(@PathVariable UUID id) {

        try {
            Sale del = salesService.deleteSale(id);

            return new ResponseEntity<>(del, HttpStatus.ACCEPTED);
        } catch (Exception exception) {

            System.out.println(exception.getMessage());
        }

        return null;
    }
}
