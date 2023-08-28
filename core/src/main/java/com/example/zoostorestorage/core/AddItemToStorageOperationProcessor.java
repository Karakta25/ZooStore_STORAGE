package com.example.zoostorestorage.core;



import com.example.zoostoreproject.restExport.ZooStoreRestClient;
import com.example.zoostorestorage.api.operations.itemstorage.item.add.AddItemToStorageInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.add.AddItemToStorageOperation;
import com.example.zoostorestorage.api.operations.itemstorage.item.add.AddItemToStorageOutput;
import com.example.zoostorestorage.core.exception.NoSuchItemException;
import com.example.zoostorestorage.persistence.OrderItemStatus;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddItemToStorageOperationProcessor<GetItemByIdOutput> implements AddItemToStorageOperation {

    private final ItemStorageRepository itemStorageRepository;
    private final ZooStoreRestClient zooStoreRestClient;

    @Override
    public AddItemToStorageOutput process(AddItemToStorageInput input) {

        Optional.ofNullable(zooStoreRestClient.getItemById(input.getItemID())).orElseThrow(NoSuchItemException::new);

        ItemStorage item = ItemStorage.builder()
                .itemID(UUID.fromString(input.getItemID()))
                .quantity(input.getQuantity())
                .price(BigDecimal.valueOf(input.getPrice()))
                .build();

        itemStorageRepository.save(item);

        return AddItemToStorageOutput.builder()
                .itemID(item.getItemID().toString())
                .quantity(item.getQuantity())
                .price(item.getPrice().doubleValue())
                .status(String.valueOf(OrderItemStatus.IN_STOCK))
                .build();


    }
}