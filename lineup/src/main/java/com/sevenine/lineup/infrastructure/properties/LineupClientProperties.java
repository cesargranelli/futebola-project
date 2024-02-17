package com.sevenine.lineup.infrastructure.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties("app.client.endpoints")
@Component
public class LineupClientProperties {
    private String gameUuidUser;
}
