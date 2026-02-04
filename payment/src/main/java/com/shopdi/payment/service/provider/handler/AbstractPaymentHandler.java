package com.shopdi.payment.service.provider.handler;

import com.shopdi.payment.service.PaymentProviderService;

abstract class AbstractPaymentHandler {
    private final PaymentProviderService paymentProviderService;

    AbstractPaymentHandler(PaymentProviderService paymentProviderService) {
        this.paymentProviderService = paymentProviderService;
    }

    String getPaymentSettings(String providerId) {
        return paymentProviderService.getAdditionalSettingsByPaymentProviderId(providerId);
    }
}
