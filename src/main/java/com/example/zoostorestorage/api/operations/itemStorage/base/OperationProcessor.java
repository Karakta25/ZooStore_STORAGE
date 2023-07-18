package com.example.zoostorestorage.api.operations.itemStorage.base;

public interface OperationProcessor<I extends OperationInput, R extends OperationResult>{

    public R process(I input);
}
