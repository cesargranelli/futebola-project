package com.sevenine.lineup.infrastructure.exception;

import lombok.Getter;

@Getter
public class NotFoundLineupException extends RuntimeException {
    public NotFoundLineupException(String message) {
        super(message);
    }
}
