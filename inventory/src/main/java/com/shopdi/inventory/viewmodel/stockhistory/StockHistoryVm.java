package com.shopdi.inventory.viewmodel.stockhistory;

import com.shopdi.inventory.model.StockHistory;
import com.shopdi.inventory.viewmodel.product.ProductInfoVm;
import java.time.ZonedDateTime;

public record StockHistoryVm(
        Long id,
        String productName,
        Long adjustedQuantity,
        String createdBy,
        ZonedDateTime createdOn,
        String note) {
    public static StockHistoryVm fromModel(StockHistory stockHistory,
            ProductInfoVm productInfoVm) {
        return new StockHistoryVm(
                stockHistory.getId(),
                productInfoVm.name(),
                stockHistory.getAdjustedQuantity(),
                stockHistory.getCreatedBy(),
                stockHistory.getCreatedOn(),
                stockHistory.getNote());
    }
}