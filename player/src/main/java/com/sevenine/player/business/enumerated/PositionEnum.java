package com.sevenine.player.business.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PositionEnum {
    G("GOALKEEPER"), D("DEFENSE"), M("MIDDLEWARE"), F("FORWARD");

    private final String name;
}
