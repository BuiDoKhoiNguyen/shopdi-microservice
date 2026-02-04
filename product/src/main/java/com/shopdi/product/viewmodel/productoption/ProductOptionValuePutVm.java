package com.shopdi.product.viewmodel.productoption;

import com.shopdi.product.model.ProductOptionValueSaveVm;
import java.util.List;

public record ProductOptionValuePutVm(
                Long productOptionId,
                String displayType,
                Integer displayOrder,
                List<String> value) implements ProductOptionValueSaveVm {
}
