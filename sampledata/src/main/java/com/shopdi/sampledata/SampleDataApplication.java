package com.shopdi.sampledata;

import com.shopdi.commonlibrary.config.CorsConfig;
import com.shopdi.commonlibrary.config.ServiceUrlConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class }, scanBasePackages = { "com.shopdi.sampledata",
        "com.shopdi.commonlibrary" })
@EnableConfigurationProperties({ ServiceUrlConfig.class, CorsConfig.class })
public class SampleDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleDataApplication.class, args);
    }
}
