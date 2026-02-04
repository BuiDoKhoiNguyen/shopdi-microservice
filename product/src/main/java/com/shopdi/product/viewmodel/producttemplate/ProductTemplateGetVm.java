package com.shopdi.product.viewmodel.producttemplate;

import com.shopdi.product.model.attribute.ProductTemplate;

public record ProductTemplateGetVm(Long id, String name) {

    public static ProductTemplateGetVm fromModel(ProductTemplate productTemplate) {
        return new ProductTemplateGetVm(
                productTemplate.getId(),
                productTemplate.getName());
    }
}
