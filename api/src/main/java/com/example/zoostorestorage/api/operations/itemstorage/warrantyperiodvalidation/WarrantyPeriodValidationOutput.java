package com.example.zoostorestorage.api.operations.itemstorage.warrantyperiodvalidation;

import com.example.zoostorestorage.api.operations.itemstorage.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WarrantyPeriodValidationOutput implements OperationResult {
    private String itemId;
    private String operation;
    private String feedback;
    private boolean success;
}
