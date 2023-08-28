package com.example.zoostorestorage.restExport;

import com.example.zoostorestorage.api.operations.itemstorage.item.add.AddItemToStorageInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.add.AddItemToStorageOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.export.ExportItemInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.export.ExportItemOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.getbyid.GetItemStorageByIdOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.importe.ImportItemInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.importe.ImportItemOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.remove.RemoveItemFromStorageInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.remove.RemoveItemFromStorageOutput;
import com.example.zoostorestorage.api.operations.itemstorage.sell.SellInput;
import com.example.zoostorestorage.api.operations.itemstorage.sell.SellOutput;
import com.example.zoostorestorage.api.operations.itemstorage.item.setprice.SetItemPriceInput;
import com.example.zoostorestorage.api.operations.itemstorage.item.setprice.SetItemPriceOutput;
import com.example.zoostorestorage.api.operations.itemstorage.warrantyperiodvalidation.WarrantyPeriodValidationInput;
import com.example.zoostorestorage.api.operations.itemstorage.warrantyperiodvalidation.WarrantyPeriodValidationOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


@Headers({"Content-Type: application/json"})
public interface ZooStorageRestClient {

    @RequestLine("POST /storage/sell")
    SellOutput sell(SellInput input);

    @RequestLine("POST /storage/warranty")
    WarrantyPeriodValidationOutput warranty(WarrantyPeriodValidationInput input);

    @RequestLine("POST /storage/importItem")
    ImportItemOutput importItem(ImportItemInput input);

    @RequestLine("PATCH /storage/exportItem")
    ExportItemOutput exportItem(@Param ExportItemInput input);

    @RequestLine("PATCH /storage/itemPrice")
    SetItemPriceOutput setItemPrice(@Param SetItemPriceInput input);

    @RequestLine("POST /storage/item")
    AddItemToStorageOutput addItemToStorage(@Param AddItemToStorageInput input);

    @RequestLine("DELETE /storage/item")
    RemoveItemFromStorageOutput removeItemFromStorage(@Param RemoveItemFromStorageInput input);

    @RequestLine("GET /storage/itemById/{itemId}")
    GetItemStorageByIdOutput getItemFromStorage(@Param String itemId);
}