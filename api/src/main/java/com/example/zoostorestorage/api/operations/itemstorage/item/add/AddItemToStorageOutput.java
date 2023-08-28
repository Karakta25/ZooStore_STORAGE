package com.example.zoostorestorage.api.operations.itemstorage.item.add;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationResult;
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
    private String status;

}
