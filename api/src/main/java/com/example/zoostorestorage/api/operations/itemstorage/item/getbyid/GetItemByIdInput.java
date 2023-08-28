package com.example.zoostorestorage.api.operations.itemstorage.item.getbyid;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetItemByIdInput implements OperationInput {

    @NotBlank(message = "Item id must not be blank!")
    private String itemID;
}
