package com.sevenine.lineup.application.config;

import com.sevenine.lineup.infrastructure.properties.LineupClientProperties;
import com.sevenine.lineup.infrastructure.properties.LineupErrorProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
        LineupErrorProperties.class,
        LineupClientProperties.class
})
public class LineupPropertiesConfig {
}
