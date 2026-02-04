package com.shopdi.product.viewmodel.productoption;

import com.shopdi.product.model.ProductOption;

public record ProductOptionGetVm(Long id, String name) {
    public static ProductOptionGetVm fromModel(ProductOption productOption) {
        return new ProductOptionGetVm(productOption.getId(), productOption.getName());
    }
}
