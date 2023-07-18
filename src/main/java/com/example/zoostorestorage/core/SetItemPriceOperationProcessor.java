package com.example.zoostorestorage.core;

import com.example.zoostorestorage.api.operations.itemStorage.setItemPrice.SetItemPriceInput;
import com.example.zoostorestorage.api.operations.itemStorage.setItemPrice.SetItemPriceOutput;
import com.example.zoostorestorage.api.operations.itemStorage.setItemPrice.SetItemPriceOperation;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SetItemPriceOperationProcessor implements SetItemPriceOperation {


    private final ItemStorageRepository itemStorageRepository;
    @Override
    public SetItemPriceOutput process(SetItemPriceInput input) {

        if(input.getPrice()<0)
        {

        }

        ItemStorage itemStorage = itemStorageRepository.findByItemID(UUID.fromString(input.getItemID()));

       itemStorage.setPrice(input.getPrice());

        itemStorageRepository.save(itemStorage);

        return SetItemPriceOutput.builder()
                        .itemID(itemStorage.getItemID().toString())
                                .price(itemStorage.getPrice()).build();

    }
}




