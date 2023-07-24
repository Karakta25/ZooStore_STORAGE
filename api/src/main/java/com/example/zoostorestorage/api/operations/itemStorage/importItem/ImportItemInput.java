package com.example.zoostorestorage.api.operations.itemStorage.importItem;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImportItemInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String itemID;
    @Positive(message = "Quantity must be positive.")
    private int importQuantity;
}
