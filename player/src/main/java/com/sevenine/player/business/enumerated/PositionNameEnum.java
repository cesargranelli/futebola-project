package com.sevenine.player.business.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PositionNameEnum {
    GOLEIRO("G"), DEFENSOR("D"), MEIA("M"), ATACANTE("F");

    private final String acronym;
}