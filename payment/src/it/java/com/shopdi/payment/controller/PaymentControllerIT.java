// package com.shopdi.payment.controller;
//
// import com.shopdi.commonlibrary.AbstractControllerIT;
// import com.shopdi.commonlibrary.IntegrationTestConfiguration;
// import com.shopdi.payment.model.CapturedPayment;
// import com.shopdi.payment.model.Payment;
// import com.shopdi.payment.model.PaymentProvider;
// import com.shopdi.payment.model.enumeration.PaymentMethod;
// import com.shopdi.payment.paypal.service.PaypalService;
// import com.shopdi.payment.repository.PaymentRepository;
// import com.shopdi.payment.service.OrderService;
// import com.shopdi.payment.service.provider.handler.PaymentHandler;
// import com.shopdi.payment.service.provider.handler.PaypalHandler;
// import com.shopdi.payment.viewmodel.CapturePaymentRequestVm;
// import com.shopdi.payment.viewmodel.CapturePaymentResponseVm;
// import com.shopdi.payment.viewmodel.PaymentOrderStatusVm;
// import io.restassured.RestAssured;
// import org.instancio.Instancio;
// import org.junit.Ignore;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import
// org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Import;
// import org.springframework.http.HttpStatus;
//
// import static org.instancio.Select.field;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
//
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @Import(IntegrationTestConfiguration.class)
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// class PaymentControllerIT extends AbstractControllerIT {
//
// private static final String PAYMENT_CAPTURE_URL = "/v1/capture";
//
// @Autowired
// PaymentRepository paymentRepository;
//
// @MockBean
// OrderService orderService;
// @MockBean
// PaypalHandler paypalHandler;
//
// Payment payment;
// CapturePaymentRequestVm capturePaymentRequestVm;
// CapturedPayment capturedPayment;
//
// @BeforeEach
// void setUp() {
// payment = paymentRepository.save(Instancio.of(Payment.class).create());
// capturedPayment = Instancio.of(CapturedPayment.class).create();
// capturePaymentRequestVm = Instancio.of(CapturePaymentRequestVm.class)
// .set(field(CapturePaymentRequestVm::paymentMethod),
// PaymentMethod.PAYPAL.name())
// .create();
//
// Mockito.when(orderService.updateCheckoutStatus(Mockito.any(CapturedPayment.class)))
// .thenAnswer(invocation -> Mockito.anyLong());
//
// Mockito.when(orderService.updateOrderStatus(Mockito.any(PaymentOrderStatusVm.class)))
// .thenAnswer(invocation -> invocation.getArgument(0));
//
// when(paypalHandler.getProviderId()).thenReturn(PaymentMethod.PAYPAL.name());
// when(paypalHandler.capturePayment(capturePaymentRequestVm)).thenAnswer(invocation
// -> capturedPayment);
// }
//
// @AfterEach
// void tearDown() {
// paymentRepository.deleteAll();
// }
//
// @Test
// void test_capturePayment_shouldReturnOrder() {
// RestAssured.given(getRequestSpecification())
// .auth().oauth2(getAccessToken("admin", "admin"))
// .body(capturePaymentRequestVm)
// .post(PAYMENT_CAPTURE_URL)
// .then()
// .statusCode(HttpStatus.OK.value())
// .log().ifValidationFails();
// }
// }