package com.shopdi.inventory.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shopdi.services")
public record ServiceUrlConfig(String product, String location) {
}
