package com.shopdi.payment.viewmodel;

import lombok.Builder;

@Builder
public record InitPaymentResponseVm(String status, String paymentId, String redirectUrl) {
}
