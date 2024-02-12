package com.sevenine.lineup.business.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FormationEnum {
    G343("3-4-3"),
    G352("3-5-2"),
    G361("3-6-1"),
    G433("4-3-3"),
    G442("4-4-2"),
    G451("4-5-1");

    private final String acronym;
}
