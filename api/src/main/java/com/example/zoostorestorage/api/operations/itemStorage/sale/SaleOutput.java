package com.example.zoostorestorage.api.operations.itemStorage.sale;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleOutput implements OperationResult {

    private Double totalPrice;
}
