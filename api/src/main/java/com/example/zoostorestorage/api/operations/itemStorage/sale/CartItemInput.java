package com.example.zoostorestorage.api.operations.itemStorage.sale;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItemInput {

    private UUID itemId;
    private Integer quantity;
    private Double price;
    private UUID userId;
}

