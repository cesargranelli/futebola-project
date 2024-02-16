package com.sevenine.game.infrastructure.exception;

import lombok.Getter;

@Getter
public class GameUnprocessableEntityException extends RuntimeException {
    public GameUnprocessableEntityException(String message) {
        super(message);
    }
}
