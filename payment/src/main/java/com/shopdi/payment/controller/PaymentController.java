package com.shopdi.payment.controller;

import com.shopdi.payment.service.PaymentService;
import com.shopdi.payment.viewmodel.CapturePaymentRequestVm;
import com.shopdi.payment.viewmodel.CapturePaymentResponseVm;
import com.shopdi.payment.viewmodel.InitPaymentRequestVm;
import com.shopdi.payment.viewmodel.InitPaymentResponseVm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping(value = "/init")
    public InitPaymentResponseVm initPayment(@Valid @RequestBody InitPaymentRequestVm initPaymentRequestVm) {
        return paymentService.initPayment(initPaymentRequestVm);
    }

    @PostMapping(value = "/capture")
    public CapturePaymentResponseVm capturePayment(
            @Valid @RequestBody CapturePaymentRequestVm capturePaymentRequestVm) {
        return paymentService.capturePayment(capturePaymentRequestVm);
    }

    @GetMapping(value = "/cancel")
    public ResponseEntity<String> cancelPayment() {
        return ResponseEntity.ok("Payment cancelled");
    }
}
