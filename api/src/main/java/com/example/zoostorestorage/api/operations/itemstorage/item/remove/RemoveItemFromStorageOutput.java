package com.example.zoostorestorage.api.operations.itemstorage.item.remove;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RemoveItemFromStorageOutput implements OperationResult {
    private String itemId;
}