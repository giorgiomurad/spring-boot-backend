package store.product.management.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "sales")
public class Sale {
    @Id
    @Column(name = "sale_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID saleId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "total_price")
    private Float totalPrice;
}
