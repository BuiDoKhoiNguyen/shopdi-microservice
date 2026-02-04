package com.shopdi.customer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shopdi.services")
public record ServiceUrlConfig(
                String location) {
}
