package com.shopdi.media.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shopdi")
public record YasConfig(String publicUrl) {
}
