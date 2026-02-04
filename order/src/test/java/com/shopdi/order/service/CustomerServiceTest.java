package com.shopdi.order.service;

import static com.shopdi.order.utils.SecurityContextUtils.setUpSecurityContext;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.shopdi.order.config.ServiceUrlConfig;
import com.shopdi.order.viewmodel.customer.CustomerVm;
import java.net.URI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

class CustomerServiceTest {

    private RestClient restClient;

    private ServiceUrlConfig serviceUrlConfig;

    private CustomerService customerService;

    private RestClient.ResponseSpec responseSpec;

    private static final String CUSTOMER_URL = "http://api.shopdi.local/customer";

    @BeforeEach
    void setUp() {
        restClient = mock(RestClient.class);
        serviceUrlConfig = mock(ServiceUrlConfig.class);
        customerService = new CustomerService(restClient, serviceUrlConfig);
        responseSpec = Mockito.mock(RestClient.ResponseSpec.class);
        setUpSecurityContext("test");
        when(serviceUrlConfig.customer()).thenReturn(CUSTOMER_URL);
    }

    @Test
    void testGetCustomer_ifNormalCase_returnCustomerVm() {

        final URI url = UriComponentsBuilder
                .fromHttpUrl(serviceUrlConfig.customer())
                .path("/storefront/customer/profile")
                .buildAndExpand()
                .toUri();

        RestClient.RequestHeadersUriSpec requestHeadersUriSpec = Mockito.mock(RestClient.RequestHeadersUriSpec.class);
        when(restClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(url)).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.headers(any())).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.retrieve()).thenReturn(responseSpec);

        CustomerVm customer = new CustomerVm(
                "john_doe",
                "john.doe@example.com",
                "John",
                "Doe");
        when(responseSpec.body(CustomerVm.class))
                .thenReturn(customer);

        CustomerVm result = customerService.getCustomer();

        assertNotNull(result);
        assertThat(result.username()).isEqualTo("john_doe");
        assertThat(result.email()).isEqualTo("john.doe@example.com");
        assertThat(result.firstName()).isEqualTo("John");
        assertThat(result.lastName()).isEqualTo("Doe");

    }

}