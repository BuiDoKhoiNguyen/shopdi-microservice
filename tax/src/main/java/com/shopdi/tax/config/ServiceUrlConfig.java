package com.shopdi.tax.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shopdi.services")
public record ServiceUrlConfig(String location) {
}
