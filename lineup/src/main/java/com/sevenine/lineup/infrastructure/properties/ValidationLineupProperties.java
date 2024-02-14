package com.sevenine.lineup.infrastructure.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties("app.errors.response")
@Component
public class ValidationLineupProperties {
    private String numberStartingPlayers;
    private String numberReservePlayers;
    private String formation;
    private String round;
}
