package com.shopdi.tax;

import com.shopdi.commonlibrary.config.CorsConfig;
import com.shopdi.tax.config.ServiceUrlConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = { "com.shopdi.tax", "com.shopdi.commonlibrary" })
@EnableConfigurationProperties({ ServiceUrlConfig.class, CorsConfig.class })
public class TaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxApplication.class, args);
    }
}
