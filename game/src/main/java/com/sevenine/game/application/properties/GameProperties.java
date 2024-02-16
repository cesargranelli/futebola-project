package com.sevenine.game.application.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("app.properties")
public class GameProperties {
    private Integer initialPoints;
}
