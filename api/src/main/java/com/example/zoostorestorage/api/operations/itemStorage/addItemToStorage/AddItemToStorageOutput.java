package com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddItemToStorageOutput implements OperationResult {
    private String itemID;
    private int quantity;
    private double price;

}
