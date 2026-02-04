package com.shopdi.product.viewmodel.product;

import com.shopdi.product.model.Product;

public record ProductInfoVm(Long id, String name, String sku) {
    public static ProductInfoVm fromProduct(Product product) {
        return new ProductInfoVm(product.getId(), product.getName(), product.getSku());
    }
}
