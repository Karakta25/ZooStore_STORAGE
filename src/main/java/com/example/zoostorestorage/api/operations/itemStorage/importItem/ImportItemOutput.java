package com.example.zoostorestorage.api.operations.itemStorage.importItem;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationResult;
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
