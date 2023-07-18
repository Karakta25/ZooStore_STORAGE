package com.example.zoostorestorage.core;

import com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage.AddItemToStorageInput;
import com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage.AddItemToStorageOutput;
import com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage.AddItemToStorageOperation;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddItemToStorageOperationProcessor implements AddItemToStorageOperation {

    private final ItemStorageRepository itemStorageRepository;


    @Override
    public AddItemToStorageOutput process(AddItemToStorageInput input) {
        ItemStorage item = ItemStorage.builder()
                .itemID(UUID.fromString(input.getItemID()))
                .quantity(input.getQuantity())
                .price(input.getPrice())
                .build();

        itemStorageRepository.save(item);

        return AddItemToStorageOutput.builder()
                .itemID(item.getItemID().toString())
                .quantity(item.getQuantity())
                .price(item.getPrice())
                .build();


    }

}
