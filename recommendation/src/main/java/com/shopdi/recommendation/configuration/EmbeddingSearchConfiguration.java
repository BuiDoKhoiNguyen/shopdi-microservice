package com.shopdi.recommendation.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "shopdi.recommendation.embedding-based.search")
public record EmbeddingSearchConfiguration(Double similarityThreshold, int topK) {
}
