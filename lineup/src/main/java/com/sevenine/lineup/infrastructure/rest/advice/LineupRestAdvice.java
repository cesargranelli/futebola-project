package com.sevenine.lineup.infrastructure.rest.advice;

import com.sevenine.lineup.infrastructure.exception.ValidationLineupException;
import com.sevenine.lineup.infrastructure.exception.error.ResponseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@RestControllerAdvice(annotations = RestController.class)
public class LineupRestAdvice {

    @ResponseBody
    @ExceptionHandler({ValidationLineupException.class})
    public ResponseEntity<?> handleConditionException(ValidationLineupException ex) {
        return ResponseEntity.status(UNPROCESSABLE_ENTITY)
                .body(new ResponseError(String.valueOf(UNPROCESSABLE_ENTITY.value()), ex.getMessage()));
    }

}
