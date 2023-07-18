package com.example.zoostorestorage.core;

import com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage.RemoveItemFromStorageInput;
import com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage.RemoveItemFromStorageOutput;
import com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage.RemoveItemFromStorageOperation;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor

public class RemoveItemFromStorageOperationProcessor implements RemoveItemFromStorageOperation {


        private final ItemStorageRepository itemStorageRepository;

        @Override
        public RemoveItemFromStorageOutput process(RemoveItemFromStorageInput input) {

            ItemStorage itemStorage = itemStorageRepository.findByItemID(UUID.fromString(input.getItemId()));
            itemStorageRepository.delete(itemStorage);
            return RemoveItemFromStorageOutput.builder().itemId(input.getItemId()).build();
        }
}
