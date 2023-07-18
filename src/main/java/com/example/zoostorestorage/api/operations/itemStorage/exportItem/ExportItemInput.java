package com.example.zoostorestorage.api.operations.itemStorage.exportItem;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExportItemInput implements OperationInput {

    private String itemID;
    private int exportQuantity;

}
