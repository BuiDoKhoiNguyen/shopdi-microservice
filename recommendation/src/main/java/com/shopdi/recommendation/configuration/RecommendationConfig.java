package com.shopdi.recommendation.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class RecommendationConfig {

    @Value("${shopdi.services.product}")
    private String apiUrl;

}
