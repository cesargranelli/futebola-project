package com.sevenine.sofascore.application.config;

import com.sevenine.sofascore.infrastructure.properties.RapidApiProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({
        RapidApiProperties.class
})
@Configuration
public class ApplicationPropertiesConfig {
}
