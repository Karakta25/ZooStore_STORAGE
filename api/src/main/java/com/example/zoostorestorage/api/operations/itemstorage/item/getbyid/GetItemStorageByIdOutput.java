package com.example.zoostorestorage.api.operations.itemstorage.item.getbyid;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemStorageByIdOutput implements OperationResult {

    private String itemID;
    private Integer quantity;
    private Double price;
    private String status;

}
