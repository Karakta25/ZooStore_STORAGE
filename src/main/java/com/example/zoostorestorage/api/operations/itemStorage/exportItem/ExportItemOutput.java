package com.example.zoostorestorage.api.operations.itemStorage.exportItem;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationResult;
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
