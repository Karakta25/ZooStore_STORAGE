package com.example.zoostorestorage.api.operations.itemStorage.sale;
import com.example.zoostorestorage.api.operations.itemStorage.base.OperationInput;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleInput implements OperationInput {

    List<CartItemInput> items;
    private UUID userId;
}
