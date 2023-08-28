package com.example.zoostorestorage.api.operations.itemstorage.sell;
import com.example.zoostorestorage.api.operations.itemstorage.base.OperationInput;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SellInput implements OperationInput {

    List<CartItemInput> items;
    private UUID userId;
}
