package com.example.zoostorestorage.rest.controllers;


import com.example.zoostorestorage.api.operations.itemstorage.item.add.AddItemToStorageInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.add.AddItemToStorageOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.add.AddItemToStorageOperation;
import com.example.zoostorestorage.api.operations.itemstorage.item.getbyid.GetItemByIdInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.getbyid.GetItemByIdOperation;
import com.example.zoostorestorage.api.operations.itemstorage.item.getbyid.GetItemStorageByIdOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.importe.ImportItemInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.importe.ImportItemOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.importe.ImportItemOperation;
import com.example.zoostorestorage.api.operations.itemstorage.item.export.ExportItemInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.export.ExportItemOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.export.ExportItemOperation;
import com.example.zoostorestorage.api.operations.itemstorage.item.remove.RemoveItemFromStorageInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.remove.RemoveItemFromStorageOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.remove.RemoveItemFromStorageOperation;
import com.example.zoostorestorage.api.operations.itemstorage.sell.SellInput;
import com.example.zoostorestorage.api.operations.itemstorage.sell.SellOperation;
import com.example.zoostorestorage.api.operations.itemstorage.sell.SellOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.setprice.SetItemPriceInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.setprice.SetItemPriceOperation;
import com.example.zoostorestorage.api.operations.itemstorage.item.setprice.SetItemPriceOutput;
import com.example.zoostorestorage.api.operations.itemstorage.warrantyperiodvalidation.WarrantyPeriodValidationInput;
import com.example.zoostorestorage.api.operations.itemstorage.warrantyperiodvalidation.WarrantyPeriodValidationOperation;
import com.example.zoostorestorage.api.operations.itemstorage.warrantyperiodvalidation.WarrantyPeriodValidationOutput;
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
    private final GetItemByIdOperation getItemByIdOperation;
    private final AddItemToStorageOperation addItemToStorageOperation;
    private final RemoveItemFromStorageOperation removeItemFromStorageOperation;
    private final SellOperation sellOperation;
    private final WarrantyPeriodValidationOperation warrantyPeriodValidationOperation;

    @PostMapping(path = "/importItem")
    public ResponseEntity<ImportItemOutput> importItem(@Valid @RequestBody ImportItemInput input)
    {
        ImportItemOutput response = importItemOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/exportItem")
    public ResponseEntity<ExportItemOutput> exportItem(@Valid @RequestBody ExportItemInput input)
    {
        ExportItemOutput response = exportItemOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(path = "/itemPrice")
    public ResponseEntity<SetItemPriceOutput> setItemPrice(@Valid @RequestBody SetItemPriceInput input)
    {
        SetItemPriceOutput response = this.setItemPriceOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/item")
    public ResponseEntity<AddItemToStorageOutput> addItemToStorage(@Valid @RequestBody AddItemToStorageInput input)
    {
        AddItemToStorageOutput response = this.addItemToStorageOperation.process(input);
        return ResponseEntity.status(201).body(response);
    }

    @PostMapping(path = "/warranty")
    public ResponseEntity<WarrantyPeriodValidationOutput> warrantyValidation(@Valid @RequestBody WarrantyPeriodValidationInput input)
    {
        WarrantyPeriodValidationOutput response = this.warrantyPeriodValidationOperation.process(input);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping(path = "/sell")
    public ResponseEntity<SellOutput> sellOperation(@Valid @RequestBody SellInput input)
    {
        SellOutput response = this.sellOperation.process(input);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping(path = "/item")
    public ResponseEntity<RemoveItemFromStorageOutput> removeItemFromStorage(@Valid @RequestBody RemoveItemFromStorageInput input) {
        RemoveItemFromStorageOutput response = this.removeItemFromStorageOperation.process(input);
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/itemById/{itemId}")
    public ResponseEntity<GetItemStorageByIdOutput> getItemFromStorage(@PathVariable String itemId)
    {
        GetItemByIdInput input = GetItemByIdInput.builder().itemID(itemId).build();

        GetItemStorageByIdOutput response = this.getItemByIdOperation.process(input);
        return ResponseEntity.ok(response);
    }



}
