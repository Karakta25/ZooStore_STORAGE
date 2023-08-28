package com.example.zoostorestorage.api.operations.itemstorage.item.add;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AddItemToStorageInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String itemID;

    @Positive(message = "Quantity must be positive.")
    private Integer quantity;

    @Positive(message = "Price must be positive!")
    private Double price;

}
