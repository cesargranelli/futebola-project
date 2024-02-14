package com.sevenine.lineup.infrastructure.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties("app.lineup")
@Component
public class LineupProperties {
    private Integer totalPlayers;
    private Integer totalReserves;
}
