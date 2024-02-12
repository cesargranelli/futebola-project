package com.sevenine.player.business.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PositionAcronymEnum {
    G("GOALKEEPER"), D("DEFENDER"), M("MIDFIELDER"), F("FORWARD"), A("ALL");

    private final String name;
}
