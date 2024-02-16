package com.sevenine.game.infrastructure.rest.advice;

import com.sevenine.game.infrastructure.exception.GameNotFoundException;
import com.sevenine.game.infrastructure.exception.GameUnprocessableEntityException;
import com.sevenine.game.infrastructure.exception.error.ResponseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@RestControllerAdvice(annotations = RestController.class)
public class GameRestAdvice {

    @ResponseBody
    @ExceptionHandler({GameUnprocessableEntityException.class})
    public ResponseEntity<?> handleUnprocessableEntity(GameUnprocessableEntityException ex) {
        return ResponseEntity.status(UNPROCESSABLE_ENTITY)
                .body(new ResponseError(String.valueOf(UNPROCESSABLE_ENTITY.value()), ex.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler({GameNotFoundException.class})
    public ResponseEntity<?> handleNotFound(GameNotFoundException ex) {
        return ResponseEntity.status(NOT_FOUND)
                .body(new ResponseError(String.valueOf(NOT_FOUND.value()), ex.getMessage()));
    }

}
