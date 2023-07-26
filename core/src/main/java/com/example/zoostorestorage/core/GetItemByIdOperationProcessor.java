package com.example.zoostorestorage.core;

import com.example.zoostorestorage.api.operations.itemStorage.getItemById.GetItemByIdInput;
import com.example.zoostorestorage.api.operations.itemStorage.getItemById.GetItemByIdOperation;
import com.example.zoostorestorage.api.operations.itemStorage.getItemById.GetItemStorageByIdOutput;
import com.example.zoostorestorage.core.exception.NoSuchItemException;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetItemByIdOperationProcessor implements GetItemByIdOperation {
    private final ItemStorageRepository itemStorageRepository;

    @Override
    public GetItemStorageByIdOutput process(GetItemByIdInput input) {


            Optional<ItemStorage> optionalItemStorage = itemStorageRepository.findByItemID(UUID.fromString(input.getItemID()));

            if(!optionalItemStorage.isPresent())
                throw new NoSuchItemException();

            ItemStorage item = optionalItemStorage.get();

            return GetItemStorageByIdOutput.builder()
                    .itemID(item.getItemID().toString())
                    .price(item.getPrice())
                    .quantity(item.getQuantity())
                    .build();

    }
}
