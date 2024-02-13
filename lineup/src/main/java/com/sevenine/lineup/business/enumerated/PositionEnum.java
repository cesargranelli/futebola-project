package com.sevenine.lineup.business.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PositionEnum {
    GOALKEEPER("GOALKEEPER", "G"),
    DEFENDER("DEFENDER", "D"),
    MIDFIELDER("MIDFIELDER", "M"),
    FORWARD("FORWARD", "F"),
    ALL("ALL", "ALL");

    private final String name;
    private final String acronym;
}

