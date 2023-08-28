package com.example.zoostorestorage.api.operations.itemstorage.item.export;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExportItemOutput implements OperationResult {

    private String itemID;
    private int actualQuantity;
}
