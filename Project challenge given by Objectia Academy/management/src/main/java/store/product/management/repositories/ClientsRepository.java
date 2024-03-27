package store.product.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import store.product.management.models.Client;

import java.util.UUID;

public interface ClientsRepository extends JpaRepository<Client, UUID> {
}
