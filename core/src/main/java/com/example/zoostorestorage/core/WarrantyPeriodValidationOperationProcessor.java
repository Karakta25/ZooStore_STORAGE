package com.example.zoostorestorage.core;


import com.example.zoostoreproject.api.operations.item.warrantycardvalidation.WarrantyCardValidationInput;
import com.example.zoostoreproject.api.operations.item.warrantycardvalidation.WarrantyCardValidationOutput;
import com.example.zoostoreproject.restExport.ZooStoreRestClient;
import com.example.zoostorestorage.api.operations.itemstorage.warrantyperiodvalidation.WarrantyPeriodValidationInput;
import com.example.zoostorestorage.api.operations.itemstorage.warrantyperiodvalidation.WarrantyPeriodValidationOperation;
import com.example.zoostorestorage.api.operations.itemstorage.warrantyperiodvalidation.WarrantyPeriodValidationOutput;
import com.example.zoostorestorage.core.exception.NoSuchItemException;
import com.example.zoostorestorage.core.exception.NoSuchRecordException;
import com.example.zoostorestorage.persistence.OrderItemStatus;
import com.example.zoostorestorage.persistence.entities.OrderItem;
import com.example.zoostorestorage.persistence.entities.OrderRecord;
import com.example.zoostorestorage.persistence.repositories.OrderItemRepository;
import com.example.zoostorestorage.persistence.repositories.OrderRecordRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WarrantyPeriodValidationOperationProcessor implements WarrantyPeriodValidationOperation {

    @Value("${MAX_WARRANTY_MONTHS}")
    private Integer maxWarrantyMonths;

    @Value("${RETURN_PERIOD_DAYS}")
    public Integer returnPeriodDays;

    private final OrderItemRepository orderItemRepository;
    private final OrderRecordRepository orderRecordRepository;
    private final ZooStoreRestClient zooStoreRestClient;

    @Override
    public WarrantyPeriodValidationOutput process(WarrantyPeriodValidationInput input) {

        OrderItem orderItem = orderItemRepository.findByItemID(UUID.fromString(input.getItemId()))
                .orElseThrow(NoSuchItemException::new);
        OrderRecord orderRecord = orderRecordRepository.findByUserId(UUID.fromString(input.getUserId()))
                .orElseThrow(NoSuchRecordException::new);

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());


        WarrantyCardValidationOutput storeWarrantyResponse = zooStoreRestClient.warrantyValidation( WarrantyCardValidationInput
                .builder()
                .itemId(input.getItemId())
                .operation(input.getOperation())
                .feedback(input.getFeedback())
                .build());

        boolean isSuccess = false;
        boolean validTimestamp = currentTime.before(Timestamp.valueOf(orderRecord.getTimestamp().toLocalDateTime().plusMonths(storeWarrantyResponse.getWarrantyPeriod())));

        if(storeWarrantyResponse.getOperation().equals("REPAIR")
                && validTimestamp && (storeWarrantyResponse.getWarrantyPeriod()>0 && storeWarrantyResponse.getWarrantyPeriod()<= maxWarrantyMonths))
        {
           orderItem.setStatus(OrderItemStatus.REPAIRED);
           orderItemRepository.save(orderItem);

            isSuccess = true;
        }

        if(ChronoUnit.DAYS.between(currentTime.toLocalDateTime(),orderRecord.getTimestamp().toLocalDateTime()) <= returnPeriodDays) {

            switch (input.getOperation()) {
                case "RETURN" -> {
                    orderItem.setStatus(OrderItemStatus.RETURNED);
                }
                case "REPLACE" -> {
                    orderItem.setStatus(OrderItemStatus.REPLACED);
                }
            }
            orderItemRepository.save(orderItem);

            isSuccess = true;
        }

        return WarrantyPeriodValidationOutput
                .builder()
                .itemId(input.getItemId())
                .operation(input.getOperation())
                .feedback(input.getFeedback())
                .success(isSuccess)
                .build();

    }
}
