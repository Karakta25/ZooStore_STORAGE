package com.example.zoostorestorage.core;

import com.example.zoostorestorage.api.operations.itemstorage.item.remove.RemoveItemFromStorageInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.remove.RemoveItemFromStorageOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.remove.RemoveItemFromStorageOperation;
import com.example.zoostorestorage.core.exception.NoSuchItemException;
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

            ItemStorage itemStorage = itemStorageRepository.findByItemID(UUID.fromString(input.getItemId()))
                    .orElseThrow(NoSuchItemException::new);

            itemStorageRepository.delete(itemStorage);
            return RemoveItemFromStorageOutput.builder().itemId(input.getItemId()).build();
        }
}
