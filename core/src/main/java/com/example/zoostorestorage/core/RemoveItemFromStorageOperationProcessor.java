package com.example.zoostorestorage.core;

import com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage.RemoveItemFromStorageInput;
import com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage.RemoveItemFromStorageOutput;
import com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage.RemoveItemFromStorageOperation;
import com.example.zoostorestorage.core.exception.NoSuchItemException;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class RemoveItemFromStorageOperationProcessor implements RemoveItemFromStorageOperation {


        private final ItemStorageRepository itemStorageRepository;

        @Override
        public RemoveItemFromStorageOutput process(RemoveItemFromStorageInput input) {

            Optional<ItemStorage> itemStorage = itemStorageRepository.findByItemID(UUID.fromString(input.getItemId()));

            if(!itemStorage.isPresent())
                throw new NoSuchItemException();

            itemStorageRepository.delete(itemStorage.get());
            return RemoveItemFromStorageOutput.builder().itemId(input.getItemId()).build();
        }
}
