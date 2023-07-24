package com.example.zoostorestorage.persistence.repositories;

import com.example.zoostorestorage.persistence.entities.ItemStorage;
import jdk.dynalink.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ItemStorageRepository extends JpaRepository<ItemStorage, UUID> {

    Optional <ItemStorage> findByItemID(UUID itemId);

}



