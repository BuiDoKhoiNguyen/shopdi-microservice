package com.shopdi.order.viewmodel.order;

import com.shopdi.order.model.Order;
import com.shopdi.order.model.enumeration.DeliveryMethod;
import com.shopdi.order.model.enumeration.DeliveryStatus;
import com.shopdi.order.model.enumeration.OrderStatus;
import com.shopdi.order.model.enumeration.PaymentStatus;
import com.shopdi.order.viewmodel.orderaddress.OrderAddressVm;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.Builder;

@Builder
public record OrderBriefVm(
        Long id,
        String email,
        OrderAddressVm billingAddressVm,
        BigDecimal totalPrice,
        OrderStatus orderStatus,
        DeliveryMethod deliveryMethod,
        DeliveryStatus deliveryStatus,
        PaymentStatus paymentStatus,
        ZonedDateTime createdOn) {
    public static OrderBriefVm fromModel(Order order) {
        return OrderBriefVm.builder()
                .id(order.getId())
                .email(order.getEmail())
                .billingAddressVm(OrderAddressVm.fromModel(order.getBillingAddressId()))
                .totalPrice(order.getTotalPrice())
                .orderStatus(order.getOrderStatus())
                .deliveryMethod(order.getDeliveryMethod())
                .deliveryStatus(order.getDeliveryStatus())
                .paymentStatus(order.getPaymentStatus())
                .createdOn(order.getCreatedOn())
                .build();
    }
}