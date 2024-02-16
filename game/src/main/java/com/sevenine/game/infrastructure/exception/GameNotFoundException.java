package com.sevenine.game.infrastructure.exception;

import lombok.Getter;

@Getter
public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(String message) {
        super(message);
    }
}
