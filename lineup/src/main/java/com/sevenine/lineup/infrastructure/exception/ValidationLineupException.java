package com.sevenine.lineup.infrastructure.exception;

import lombok.Getter;

@Getter
public class ValidationLineupException extends RuntimeException {
    public ValidationLineupException(String message) {
        super(message);
    }
}
