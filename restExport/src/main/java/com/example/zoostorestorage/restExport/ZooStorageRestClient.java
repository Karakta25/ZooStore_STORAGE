package com.example.zoostorestorage.restExport;

import com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage.AddItemToStorageInput;
import com.example.zoostorestorage.api.operations.itemStorage.addItemToStorage.AddItemToStorageOutput;
import com.example.zoostorestorage.api.operations.itemStorage.exportItem.ExportItemInput;
import com.example.zoostorestorage.api.operations.itemStorage.exportItem.ExportItemOutput;
import com.example.zoostorestorage.api.operations.itemStorage.getItemById.GetItemStorageByIdOutput;
import com.example.zoostorestorage.api.operations.itemStorage.importItem.ImportItemInput;
import com.example.zoostorestorage.api.operations.itemStorage.importItem.ImportItemOutput;
import com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage.RemoveItemFromStorageInput;
import com.example.zoostorestorage.api.operations.itemStorage.removeItemFromStorage.RemoveItemFromStorageOutput;
import com.example.zoostorestorage.api.operations.itemStorage.setItemPrice.SetItemPriceInput;
import com.example.zoostorestorage.api.operations.itemStorage.setItemPrice.SetItemPriceOutput;
import feign.Headers;
import feign.Param;
import feign.RequestLine;


@Headers({"Content-Type: application/json"})
public interface ZooStorageRestClient {

    @RequestLine("PATCH /storage/importItem")
    ImportItemOutput importItem(@Param ImportItemInput input);

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