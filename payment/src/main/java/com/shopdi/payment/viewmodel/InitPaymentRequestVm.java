package com.shopdi.payment.viewmodel;

import java.math.BigDecimal;
import lombok.Builder;

@Builder
public record InitPaymentRequestVm(String paymentMethod, BigDecimal totalPrice, String checkoutId) {
}