package com.example.zoostorestorage.persistence.repositories;

import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {
}
