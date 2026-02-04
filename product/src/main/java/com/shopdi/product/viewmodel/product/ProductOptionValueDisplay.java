package com.shopdi.product.viewmodel.product;

import com.shopdi.product.model.ProductOptionValueSaveVm;
import lombok.Builder;

@Builder(toBuilder = true)
public record ProductOptionValueDisplay(
                Long productOptionId,
                String displayType,
                Integer displayOrder,
                String value) implements ProductOptionValueSaveVm {
}
