package com.shopdi.product.viewmodel.brand;

import com.shopdi.product.model.Brand;

public record BrandVm(Long id, String name, String slug, Boolean isPublish) {
    public static BrandVm fromModel(Brand brand) {
        return new BrandVm(brand.getId(), brand.getName(), brand.getSlug(), brand.isPublished());
    }
}
