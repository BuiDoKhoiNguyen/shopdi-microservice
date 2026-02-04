package com.shopdi.payment;

import com.shopdi.commonlibrary.config.CorsConfig;
import com.shopdi.payment.config.ServiceUrlConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = { "com.shopdi.payment", "com.shopdi.commonlibrary" })
@EnableConfigurationProperties({ ServiceUrlConfig.class, CorsConfig.class })
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }
}
