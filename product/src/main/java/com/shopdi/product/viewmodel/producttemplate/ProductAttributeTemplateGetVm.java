package com.shopdi.product.viewmodel.producttemplate;

import com.shopdi.product.model.attribute.ProductAttributeTemplate;
import com.shopdi.product.viewmodel.productattribute.ProductAttributeVm;

public record ProductAttributeTemplateGetVm(
        ProductAttributeVm productAttribute,
        Integer displayOrder) {
    public static ProductAttributeTemplateGetVm fromModel(ProductAttributeTemplate productAttributeTemplate) {
        return new ProductAttributeTemplateGetVm(
                ProductAttributeVm.fromModel(productAttributeTemplate.getProductAttribute()),
                productAttributeTemplate.getDisplayOrder());
    }
}
