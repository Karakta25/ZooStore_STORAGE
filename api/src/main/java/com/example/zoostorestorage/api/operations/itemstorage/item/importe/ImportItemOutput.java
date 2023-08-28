package com.example.zoostorestorage.api.operations.itemstorage.item.importe;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImportItemOutput implements OperationResult {

    private String itemID;
    private int actualQuantity;
}
