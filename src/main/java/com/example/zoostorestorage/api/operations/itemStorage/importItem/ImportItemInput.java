package com.example.zoostorestorage.api.operations.itemStorage.importItem;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImportItemInput implements OperationInput {

    private String itemID;
    private int importQuantity;
}
