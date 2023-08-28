package com.example.zoostorestorage.core;


import com.example.zoostorestorage.api.operations.itemstorage.sell.CartItemInput;
import com.example.zoostorestorage.api.operations.itemstorage.sell.SellInput;
import com.example.zoostorestorage.api.operations.itemstorage.sell.SellOperation;
import com.example.zoostorestorage.api.operations.itemstorage.sell.SellOutput;
import com.example.zoostorestorage.core.exception.InsufficientAvailabilityException;
import com.example.zoostorestorage.core.exception.NoSuchItemException;
import com.example.zoostorestorage.persistence.OrderItemStatus;
import com.example.zoostorestorage.persistence.entities.ItemStorage;
import com.example.zoostorestorage.persistence.entities.OrderItem;
import com.example.zoostorestorage.persistence.entities.OrderRecord;
import com.example.zoostorestorage.persistence.repositories.ItemStorageRepository;
import com.example.zoostorestorage.persistence.repositories.OrderItemRepository;
import com.example.zoostorestorage.persistence.repositories.OrderRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SellOperationProcessor implements SellOperation {

    private final ItemStorageRepository itemStorageRepository;
    private final OrderRecordRepository orderRecordRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public SellOutput process(SellInput input) {

        List<OrderItem> items = new ArrayList<>();
        UUID userId = input.getUserId();

        OrderRecord record = OrderRecord.builder()
                .userId(userId)
                .items(items)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();

        orderRecordRepository.save(record);

        input.getItems().parallelStream()
                .forEach(item -> {
                    ItemStorage itemStorage = itemStorageRepository.findByItemID(item.getItemId())
                            .orElseThrow(NoSuchItemException::new);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (item.getQuantity() > itemStorage.getQuantity()) {
                        throw new InsufficientAvailabilityException("InsufficientAvailability of " + item.getItemId());
                    }

                    if (item.getQuantity() == itemStorage.getQuantity()) {
                        itemStorageRepository.delete(itemStorage);
                    }

                    itemStorage.setQuantity(itemStorage.getQuantity() - item.getQuantity());
                    itemStorageRepository.save(itemStorage);

                    record.setTotalPrice(record.getTotalPrice().add(BigDecimal.valueOf(item.getPrice())));

                    OrderItem orderItem = getOrderItem(item, record);
                    orderItemRepository.save(orderItem);

                    record.getItems().add(orderItem);
                    orderRecordRepository.save(record);
                });


        return SellOutput
                .builder()
                .totalPrice(record.getTotalPrice().doubleValue())
                .build();
    }

    private OrderItem getOrderItem(CartItemInput item, OrderRecord record) {
        return OrderItem.builder()
                .itemID(item.getItemId())
                .quantity(item.getQuantity())
                .orderRecord(record)
                .status(OrderItemStatus.SOLD)
                .build();
    }
}
