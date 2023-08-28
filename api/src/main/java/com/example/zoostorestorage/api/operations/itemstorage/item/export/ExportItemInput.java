package com.example.zoostorestorage.api.operations.itemstorage.item.export;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExportItemInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String itemID;
    @Positive(message = "Quantity must be positive.")
    private int exportQuantity;

}
