package com.shopdi.product.viewmodel.productattribute;

import java.util.List;

public record ProductAttributeGroupGetVm(String name, List<ProductAttributeValueVm> productAttributeValues) {
}
