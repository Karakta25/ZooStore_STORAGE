package com.example.zoostorestorage.api.operations.itemstorage.base;

public interface OperationProcessor<I extends OperationInput, R extends OperationResult>{

    R process(I input);
}
