package com.sevenine.provider.application.config;

import com.sevenine.provider.infrastructure.properties.ApiDojoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({
        ApiDojoProperties.class
})
@Configuration
public class ApplicationPropertiesConfig {
}
