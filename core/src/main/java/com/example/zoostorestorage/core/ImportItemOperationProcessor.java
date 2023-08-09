package com.example.zoostorestorage.core;

import com.example.zoostorestorage.api.operations.itemStorage.importItem.ImportItemInput;
import com.example.zoostorestorage.api.operations.itemStorage.importItem.ImportItemOutput;
import com.example.zoostorestorage.api.operations.itemStorage.importItem.ImportItemOperation;
import com.example.zoostorestorage.core.exception.NoSuchItemException;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImportItemOperationProcessor implements ImportItemOperation {

    private final ItemStorageRepository itemStorageRepository;
    @Override
    public ImportItemOutput process(ImportItemInput input) {

        ItemStorage itemStorage = itemStorageRepository.findByItemID(UUID.fromString(input.getItemID()))
                .orElseThrow(NoSuchItemException::new);

            itemStorage.setQuantity(itemStorage.getQuantity() + input.getImportQuantity());

            itemStorageRepository.save(itemStorage);

            return ImportItemOutput.builder()
                    .itemID(itemStorage.getItemID().toString())
                    .actualQuantity(itemStorage.getQuantity()).build();

    }
}


