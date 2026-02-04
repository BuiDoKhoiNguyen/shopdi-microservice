package com.shopdi.webhook.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shopdi.services")
public record ServiceUrlConfig(String location) {
}
