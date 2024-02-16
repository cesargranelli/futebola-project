package com.sevenine.game.application.config;

import com.sevenine.game.application.properties.GameProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({GameProperties.class})
@Configuration
public class GamePropertiesConfig {
}
