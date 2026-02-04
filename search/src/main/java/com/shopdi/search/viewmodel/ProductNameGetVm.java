package com.shopdi.search.viewmodel;

import com.shopdi.search.model.Product;

public record ProductNameGetVm(String name) {
    public static ProductNameGetVm fromModel(Product product) {
        return new ProductNameGetVm(
                product.getName());
    }
}
