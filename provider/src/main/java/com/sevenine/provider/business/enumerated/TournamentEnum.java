package com.sevenine.provider.business.enumerated;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TournamentEnum {
    PAULISTA("372"), BRASILEIRO("325");

    private final String code;
}
