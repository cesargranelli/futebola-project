package com.sevenine.player.business.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PositionNameEnum {
    GOALKEEPER("G"), DEFENDER("D"), MIDFIELDER("M"), FORWARD("F"), ALL("ALL");

    private final String acronym;
}
