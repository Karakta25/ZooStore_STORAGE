package com.example.zoostorestorage.persistence.repositories;

import com.example.zoostorestorage.persistence.entities.ItemStorage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemStorageRepository extends JpaRepository<ItemStorage, UUID>{

    ItemStorage findByItemID(UUID id);
}
