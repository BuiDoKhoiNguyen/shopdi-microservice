package com.shopdi.media;

import com.shopdi.commonlibrary.config.CorsConfig;
import com.shopdi.media.config.YasConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = { "com.shopdi.media", "com.shopdi.commonlibrary" })
@EnableConfigurationProperties({ YasConfig.class, CorsConfig.class })
public class MediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediaApplication.class, args);
    }

}
