package com.sevenine.lineup.business.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PositionNameEnum {
    GOLEIRO("G"), DEFENSOR("D"), MEIA("M"), ATACANTE("F"), TODAS("ALL");

    private final String acronym;
}
