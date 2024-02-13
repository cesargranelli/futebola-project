package com.sevenine.lineup.infrastructure.exception;

import lombok.Getter;

@Getter
public class QuantityPlayersException extends ValidationLineupException {
    public QuantityPlayersException(String message) {
        super(message);
    }
}
