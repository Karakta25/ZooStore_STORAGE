package com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AddItemToStorageInput implements OperationInput {

    private String itemID;
    private int quantity;
    private double price;

}
