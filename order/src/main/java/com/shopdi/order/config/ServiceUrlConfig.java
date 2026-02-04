package com.shopdi.order.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shopdi.services")
public record ServiceUrlConfig(
                String cart, String customer, String product, String tax, String promotion) {
}
