package com.sevenine.lineup.business.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PositionAcronymEnum {
    G("GOLEIRO"), D("DEFENSOR"), M("MEIA"), F("ATACANTE");

    private final String name;
}
