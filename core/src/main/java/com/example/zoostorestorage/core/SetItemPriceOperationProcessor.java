package com.example.zoostorestorage.core;

import com.example.zoostorestorage.api.operations.itemstorage.item.setprice.SetItemPriceInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.setprice.SetItemPriceOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.setprice.SetItemPriceOperation;
import com.example.zoostorestorage.core.exception.NegativeItemPriceException;
import com.example.zoostorestorage.core.exception.NoSuchItemException;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SetItemPriceOperationProcessor implements SetItemPriceOperation {


    private final ItemStorageRepository itemStorageRepository;
    @Override
    public SetItemPriceOutput process(SetItemPriceInput input) {

        ItemStorage itemStorage = itemStorageRepository.findByItemID(UUID.fromString(input.getItemID()))
                .orElseThrow(NoSuchItemException::new);


        if(input.getPrice()<0)
            throw new NegativeItemPriceException();

        itemStorage.setPrice(BigDecimal.valueOf(input.getPrice()));

        itemStorageRepository.save(itemStorage);

        return SetItemPriceOutput.builder()
                        .itemID(itemStorage.getItemID().toString())
                        .price(itemStorage.getPrice().doubleValue()).build();

    }
}




