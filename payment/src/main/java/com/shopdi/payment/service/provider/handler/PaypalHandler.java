package com.shopdi.payment.service.provider.handler;

import com.shopdi.payment.model.CapturedPayment;
import com.shopdi.payment.model.InitiatedPayment;
import com.shopdi.payment.model.enumeration.PaymentMethod;
import com.shopdi.payment.model.enumeration.PaymentStatus;
import com.shopdi.payment.paypal.service.PaypalService;
import com.shopdi.payment.paypal.viewmodel.PaypalCapturePaymentRequest;
import com.shopdi.payment.paypal.viewmodel.PaypalCapturePaymentResponse;
import com.shopdi.payment.paypal.viewmodel.PaypalCreatePaymentRequest;
import com.shopdi.payment.paypal.viewmodel.PaypalCreatePaymentResponse;
import com.shopdi.payment.service.PaymentProviderService;
import com.shopdi.payment.viewmodel.CapturePaymentRequestVm;
import com.shopdi.payment.viewmodel.InitPaymentRequestVm;
import org.springframework.stereotype.Component;

@Component
public class PaypalHandler extends AbstractPaymentHandler implements PaymentHandler {

    private final PaypalService paypalService;

    PaypalHandler(PaymentProviderService paymentProviderService, PaypalService paypalService) {
        super(paymentProviderService);
        this.paypalService = paypalService;
    }

    @Override
    public String getProviderId() {
        return PaymentMethod.PAYPAL.name();
    }

    @Override
    public InitiatedPayment initPayment(InitPaymentRequestVm initPaymentRequestVm) {
        PaypalCreatePaymentRequest requestPayment = PaypalCreatePaymentRequest.builder()
                .totalPrice(initPaymentRequestVm.totalPrice())
                .checkoutId(initPaymentRequestVm.checkoutId())
                .paymentMethod(initPaymentRequestVm.paymentMethod())
                .paymentSettings(getPaymentSettings(getProviderId()))
                .build();
        PaypalCreatePaymentResponse paypalCreatePaymentResponse = paypalService.createPayment(requestPayment);
        return InitiatedPayment.builder()
                .status(paypalCreatePaymentResponse.status())
                .paymentId(paypalCreatePaymentResponse.paymentId())
                .redirectUrl(paypalCreatePaymentResponse.redirectUrl())
                .build();
    }

    @Override
    public CapturedPayment capturePayment(CapturePaymentRequestVm capturePaymentRequestVm) {
        PaypalCapturePaymentRequest paypalCapturePaymentRequest = PaypalCapturePaymentRequest.builder()
                .token(capturePaymentRequestVm.token())
                .paymentSettings(getPaymentSettings(getProviderId()))
                .build();
        PaypalCapturePaymentResponse paypalCapturePaymentResponse = paypalService.capturePayment(
                paypalCapturePaymentRequest);
        return CapturedPayment.builder()
                .checkoutId(paypalCapturePaymentResponse.checkoutId())
                .amount(paypalCapturePaymentResponse.amount())
                .paymentFee(paypalCapturePaymentResponse.paymentFee())
                .gatewayTransactionId(paypalCapturePaymentResponse.gatewayTransactionId())
                .paymentMethod(PaymentMethod.valueOf(paypalCapturePaymentResponse.paymentMethod()))
                .paymentStatus(PaymentStatus.valueOf(paypalCapturePaymentResponse.paymentStatus()))
                .failureMessage(paypalCapturePaymentResponse.failureMessage())
                .build();
    }
}
