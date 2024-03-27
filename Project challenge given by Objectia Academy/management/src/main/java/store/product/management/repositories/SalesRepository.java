package store.product.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.product.management.models.Sale;

import java.util.UUID;

@Repository
public interface SalesRepository extends JpaRepository<Sale, UUID> {
}
