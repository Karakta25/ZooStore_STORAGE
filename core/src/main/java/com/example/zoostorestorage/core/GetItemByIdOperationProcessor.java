package com.example.zoostorestorage.core;

import com.example.zoostorestorage.api.operations.itemstorage.item.getbyid.GetItemByIdInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.getbyid.GetItemByIdOperation;
import com.example.zoostorestorage.api.operations.itemstorage.item.getbyid.GetItemStorageByIdOutput;
import com.example.zoostorestorage.core.exception.NoSuchItemException;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetItemByIdOperationProcessor implements GetItemByIdOperation {
    private final ItemStorageRepository itemStorageRepository;

    @Override
    public GetItemStorageByIdOutput process(GetItemByIdInput input) {


        ItemStorage item = itemStorageRepository.findByItemID(UUID.fromString(input.getItemID()))
                .orElseThrow(NoSuchItemException::new);

            return GetItemStorageByIdOutput.builder()
                    .itemID(item.getItemID().toString())
                    .price(item.getPrice().doubleValue())
                    .quantity(item.getQuantity())
                    .build();

    }
}
