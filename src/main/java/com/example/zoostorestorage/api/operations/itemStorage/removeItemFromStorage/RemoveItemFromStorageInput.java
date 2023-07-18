package com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage;

import com.example.zoostorestorage.api.operations.itemStorage.base.OperationInput;
import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RemoveItemFromStorageInput implements OperationInput {

   private String itemId;
}
