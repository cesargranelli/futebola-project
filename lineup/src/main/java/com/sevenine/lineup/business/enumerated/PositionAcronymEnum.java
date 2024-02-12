package com.sevenine.lineup.business.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PositionAcronymEnum {
    G("GOALKEEPER"), D("DEFENDER"), M("MIDFIELDER"), F("FORWARD"), A("ALL");

    private final String name;
}
