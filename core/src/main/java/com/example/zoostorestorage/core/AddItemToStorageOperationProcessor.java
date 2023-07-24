package com.example.zoostorestorage.core;


import com.example.zoostoreproject.restExport.ZooStoreRestClient;
import com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage.AddItemToStorageInput;
import com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage.AddItemToStorageOperation;
import com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage.AddItemToStorageOutput;
import com.example.zoostorestorage.core.exception.NoSuchItemException;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddItemToStorageOperationProcessor<GetItemByIdOutput> implements AddItemToStorageOperation {

    private final ItemStorageRepository itemStorageRepository;
    private final ZooStoreRestClient zooStoreRestClient;



    @Override
    public AddItemToStorageOutput process(AddItemToStorageInput input) {
        try
        {
             zooStoreRestClient.getItemById(input.getItemID());
        }
        catch (Exception e)
        {
            throw new NoSuchItemException();
        }

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
