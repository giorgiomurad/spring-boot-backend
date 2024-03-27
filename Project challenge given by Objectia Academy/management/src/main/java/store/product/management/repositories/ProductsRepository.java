package store.product.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.product.management.models.Product;

import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<Product, UUID> {
}
