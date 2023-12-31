package com.example.zoostorestorage.persistence.entities;

import com.example.zoostorestorage.persistence.OrderItemStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "itemID", nullable = false)
    private UUID itemID;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(nullable = false)
    private OrderItemStatus status;

    @ManyToOne
    @JoinColumn(name = "order_record_id", nullable = false)
    private OrderRecord orderRecord;

}
