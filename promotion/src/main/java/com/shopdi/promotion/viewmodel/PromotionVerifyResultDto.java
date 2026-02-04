package com.shopdi.promotion.viewmodel;

import com.shopdi.promotion.model.enumeration.DiscountType;

public record PromotionVerifyResultDto(
        boolean isValid,
        Long productId,
        String couponCode,
        DiscountType discountType,
        Long discountValue) {
}
