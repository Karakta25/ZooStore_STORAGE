package com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationInput;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveItemFromStorageInput implements OperationInput {

   @NotBlank(message = "Item id must not be blank!")
   private String itemId;
}
