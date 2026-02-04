package com.shopdi.inventory.viewmodel.stock;

import com.shopdi.inventory.model.Stock;
import com.shopdi.inventory.viewmodel.product.ProductInfoVm;

public record StockVm(
        Long id,
        Long productId,
        String productName,
        String productSku,
        Long quantity,
        Long reservedQuantity,
        Long warehouseId) {
    public static StockVm fromModel(Stock stock,
            ProductInfoVm productInfoVm) {
        return new StockVm(
                stock.getId(),
                stock.getProductId(),
                productInfoVm.name(),
                productInfoVm.sku(),
                stock.getQuantity(),
                stock.getReservedQuantity(),
                stock.getWarehouse().getId());
    }
}
