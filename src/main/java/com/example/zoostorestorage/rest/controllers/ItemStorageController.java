package com.example.zoostorestorage.rest.controllers;

import com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage.AddItemToStorageInput;
import com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage.AddItemToStorageOutput;
import com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage.AddItemToStorageOperation;
import com.example.zoostorestorage.api.operations.itemStorage.importItem.ImportItemInput;
import com.example.zoostorestorage.api.operations.itemStorage.importItem.ImportItemOutput;
import com.example.zoostorestorage.api.operations.itemStorage.importItem.ImportItemOperation;
import com.example.zoostorestorage.api.operations.itemStorage.exportItem.ExportItemInput;
import com.example.zoostorestorage.api.operations.itemStorage.exportItem.ExportItemOutput;
import com.example.zoostorestorage.api.operations.itemStorage.exportItem.ExportItemOperation;
import com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage.RemoveItemFromStorageInput;
import com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage.RemoveItemFromStorageOutput;
import com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage.RemoveItemFromStorageOperation;
import com.example.zoostorestorage.api.operations.itemStorage.setItemPrice.SetItemPriceInput;
import com.example.zoostorestorage.api.operations.itemStorage.setItemPrice.SetItemPriceOperation;
import com.example.zoostorestorage.api.operations.itemStorage.setItemPrice.SetItemPriceOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/storage")
@RequiredArgsConstructor
public class ItemStorageController {

    private final ImportItemOperation importItemOperation;
    private final ExportItemOperation exportItemOperation;
    private final SetItemPriceOperation setItemPriceOperation;
    private final AddItemToStorageOperation addItemToStorageOperation;
    private final RemoveItemFromStorageOperation removeItemFromStorageOperation;

    @PatchMapping(path = "/importItem")
    public ImportItemOutput importItem(@RequestBody ImportItemInput input)
    {
        return importItemOperation.process(input);
    }

    @PatchMapping(path = "/exportItem")
    public ExportItemOutput exportItem(@RequestBody ExportItemInput input)
    {
        return exportItemOperation.process(input);
    }

    @PatchMapping(path = "/setItemPrice")
    public SetItemPriceOutput setItemPrice(@RequestBody SetItemPriceInput input)
    {
        return setItemPriceOperation.process(input);
    }

    @PostMapping(path = "/addItem")
    public ResponseEntity<AddItemToStorageOutput> addItemToStorage(@Valid @RequestBody AddItemToStorageInput input)
    {
        AddItemToStorageOutput response = this.addItemToStorageOperation.process(input);
        return ResponseEntity.status(201).body(response);
    }

    @DeleteMapping(path = "item/delete")
    public ResponseEntity<RemoveItemFromStorageOutput> removeItemFromStorage(@Valid @RequestBody RemoveItemFromStorageInput input) {
        RemoveItemFromStorageOutput response =  this.removeItemFromStorageOperation.process(input);
        return ResponseEntity.ok(response);
    }
}
