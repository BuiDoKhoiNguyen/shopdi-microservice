package com.shopdi.product.viewmodel.product;

import com.shopdi.product.model.ProductVariationSaveVm;
import java.util.List;

public interface ProductSaveVm<T extends ProductVariationSaveVm> extends ProductProperties {
    List<T> variations();

    Boolean isPublished();

    Double length();

    Double width();

    @Override
    default Long id() {
        return null;
    }
}
