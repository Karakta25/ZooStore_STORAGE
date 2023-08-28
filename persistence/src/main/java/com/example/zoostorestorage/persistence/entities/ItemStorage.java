package com.example.zoostorestorage.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "storages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "itemID",unique = true, nullable = false)
    private UUID itemID;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

}
