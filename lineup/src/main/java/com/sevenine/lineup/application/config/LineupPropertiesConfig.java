package com.sevenine.lineup.application.config;

import com.sevenine.lineup.infrastructure.properties.ValidationLineupProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
        ValidationLineupProperties.class
})
public class LineupPropertiesConfig {
}
