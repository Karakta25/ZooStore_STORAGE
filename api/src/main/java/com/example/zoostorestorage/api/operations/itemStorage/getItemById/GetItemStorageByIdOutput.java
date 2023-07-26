package com.example.zoostorestorage.api.operations.itemStorage.getItemById;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemStorageByIdOutput implements OperationResult {

    private String itemID;
    private int quantity;
    private double price;

}
