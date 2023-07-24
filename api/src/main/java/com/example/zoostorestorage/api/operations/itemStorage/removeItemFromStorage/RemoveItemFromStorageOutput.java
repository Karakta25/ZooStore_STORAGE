package com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RemoveItemFromStorageOutput implements OperationResult {
    private String itemId;
}