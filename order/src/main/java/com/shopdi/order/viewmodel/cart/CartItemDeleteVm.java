package com.shopdi.order.viewmodel.cart;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CartItemDeleteVm(@NotNull Long productId,
        @NotNull @Min(1) Integer quantity) {
}
