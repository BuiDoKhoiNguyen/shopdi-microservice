package com.shopdi.payment.service.provider.handler;

import com.shopdi.payment.model.CapturedPayment;
import com.shopdi.payment.model.InitiatedPayment;
import com.shopdi.payment.viewmodel.CapturePaymentRequestVm;
import com.shopdi.payment.viewmodel.InitPaymentRequestVm;

public interface PaymentHandler {
    String getProviderId();

    InitiatedPayment initPayment(InitPaymentRequestVm initPaymentRequestVm);

    CapturedPayment capturePayment(CapturePaymentRequestVm capturePaymentRequestVm);
}
