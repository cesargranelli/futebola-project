package com.sevenine.lineup.infrastructure.exception;

import lombok.Getter;

@Getter
public class FormationException extends ValidationLineupException {
    public FormationException(String message) {
        super(message);
    }
}
