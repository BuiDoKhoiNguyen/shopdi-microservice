package com.shopdi.product;

import com.shopdi.commonlibrary.config.CorsConfig;
import com.shopdi.commonlibrary.config.ServiceUrlConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = { "com.shopdi.product", "com.shopdi.commonlibrary" })
@EnableConfigurationProperties({ ServiceUrlConfig.class, CorsConfig.class })
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
