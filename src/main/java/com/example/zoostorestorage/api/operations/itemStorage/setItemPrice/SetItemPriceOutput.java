package com.example.zoostorestorage.api.operations.itemStorage.setItemPrice;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SetItemPriceOutput implements OperationResult {

    private String itemID;
    private double price;
}
