package com.example.zoostorestorage.api.operations.itemstorage.item.setprice;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationResult;
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
