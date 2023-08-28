package com.example.zoostorestorage.api.operations.itemstorage.warrantyperiodvalidation;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarrantyPeriodValidationInput implements OperationInput {

    private String itemId;
    private String operation;
    private String feedback;
    private String userId;
}
