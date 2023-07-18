package com.example.zoostorestorage.api.operations.itemStorage.setItemPrice;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SetItemPriceInput implements OperationInput {

    private String itemID;
    private double price;
}
