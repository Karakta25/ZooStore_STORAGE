package com.example.zoostorestorage.api.operations.itemstorage.sell;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellOutput implements OperationResult {

    private Double totalPrice;
}
