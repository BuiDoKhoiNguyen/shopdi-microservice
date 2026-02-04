package com.shopdi.commonlibrary.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shopdi.services")
public record ServiceUrlConfig(String media, String product) {
}
