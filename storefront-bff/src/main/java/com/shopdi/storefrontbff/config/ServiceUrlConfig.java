package com.shopdi.storefrontbff.config;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shopdi")
public record ServiceUrlConfig(
        Map<String, String> services) {
}
