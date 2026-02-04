package com.shopdi.product.viewmodel.product;

import com.shopdi.product.model.Product;

public record ProductGetDetailVm(long id, String name, String slug) {
    public static ProductGetDetailVm fromModel(Product product) {
        return new ProductGetDetailVm(product.getId(), product.getName(), product.getSlug());
    }
}