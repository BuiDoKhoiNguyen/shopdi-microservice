package com.shopdi.product.viewmodel.product;

import com.shopdi.product.model.Category;
import com.shopdi.product.model.enumeration.DimensionUnit;
import com.shopdi.product.viewmodel.ImageVm;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record ProductDetailVm(
                long id,
                String name,
                String shortDescription,
                String description,
                String specification,
                String sku,
                String gtin,
                String slug,
                Boolean isAllowedToOrder,
                Boolean isPublished,
                Boolean isFeatured,
                Boolean isVisible,
                Boolean stockTrackingEnabled,
                Double weight,
                DimensionUnit dimensionUnit,
                Double length,
                Double width,
                Double height,
                Double price,
                Long brandId,
                List<Category> categories,
                String metaTitle,
                String metaKeyword,
                String metaDescription,
                ImageVm thumbnailMedia,
                List<ImageVm> productImageMedias,
                Long taxClassId,
                Long parentId) {
}
