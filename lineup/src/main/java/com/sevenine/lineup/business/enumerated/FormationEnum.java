package com.sevenine.lineup.business.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FormationEnum {
    G343("G343", "G1-D3-M4-F3"),
    G352("G352", "G1-D3-M5-F2"),
    G361("G361", "G1-D3-M6-F1"),
    G433("G433", "G1-D4-M3-F3"),
    G442("G442", "G1-D4-M4-F2"),
    G451("G451", "G1-D4-M5-F1");

    private final String name;
    private final String acronym;
}
