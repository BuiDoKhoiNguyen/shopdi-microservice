package com.shopdi.payment.model;

import com.shopdi.payment.model.enumeration.PaymentMethod;
import com.shopdi.payment.model.enumeration.PaymentStatus;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class CapturedPayment {
    Long orderId;
    String checkoutId;
    BigDecimal amount;
    BigDecimal paymentFee;
    String gatewayTransactionId;
    PaymentMethod paymentMethod;
    PaymentStatus paymentStatus;
    String failureMessage;
}
