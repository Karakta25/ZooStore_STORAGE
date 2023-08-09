package com.example.zoostorestorage.core;


import com.example.zoostorestorage.api.operations.itemStorage.exportItem.ExportItemInput;
import com.example.zoostorestorage.api.operations.itemStorage.exportItem.ExportItemOperation;
import com.example.zoostorestorage.api.operations.itemStorage.exportItem.ExportItemOutput;
import com.example.zoostorestorage.core.exception.NegativeUpdatedQuantityException;
import com.example.zoostorestorage.core.exception.NoSuchItemException;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExportItemOperationProcessor implements ExportItemOperation {

    private final ItemStorageRepository itemStorageRepository;


    @Override
    public ExportItemOutput process(ExportItemInput input) {

        ItemStorage itemStorage = itemStorageRepository.findByItemID(UUID.fromString(input.getItemID()))
                .orElseThrow(NoSuchItemException::new);

        if(itemStorage.getQuantity() - input.getExportQuantity() < 0)
            throw new NegativeUpdatedQuantityException();


        itemStorage.setQuantity(itemStorage.getQuantity() - input.getExportQuantity());

        itemStorageRepository.save(itemStorage);

        return ExportItemOutput.builder()
                .itemID(itemStorage.getItemID().toString())
                .actualQuantity(itemStorage.getQuantity()).build();

    }

}

