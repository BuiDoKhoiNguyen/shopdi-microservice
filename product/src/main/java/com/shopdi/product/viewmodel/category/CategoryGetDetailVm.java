package com.shopdi.product.viewmodel.category;

import com.shopdi.product.model.Category;
import com.shopdi.product.viewmodel.ImageVm;

public record CategoryGetDetailVm(long id, String name, String slug, String description, long parentId,
        String metaKeywords, String metaDescription, short displayOrder, Boolean isPublish,
        ImageVm categoryImage) {
    public static CategoryGetDetailVm fromModel(Category category) {
        if (category.getParent() != null) {
            return new CategoryGetDetailVm(category.getId(), category.getName(), category.getSlug(),
                    category.getDescription(), category.getParent().getId(), category.getMetaKeyword(),
                    category.getMetaDescription(), category.getDisplayOrder(), category.getIsPublished(), null);
        } else {
            return new CategoryGetDetailVm(category.getId(), category.getName(), category.getSlug(),
                    category.getDescription(), 0L, category.getMetaKeyword(), category.getMetaDescription(),
                    category.getDisplayOrder(), category.getIsPublished(), null);
        }
    }
}
