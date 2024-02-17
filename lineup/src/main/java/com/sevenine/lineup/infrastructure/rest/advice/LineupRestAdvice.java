package com.sevenine.lineup.infrastructure.rest.advice;

import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.infrastructure.exception.NotFoundLineupException;
import com.sevenine.lineup.infrastructure.exception.ValidationLineupException;
import com.sevenine.lineup.infrastructure.exception.error.ResponseError;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@RequiredArgsConstructor
@RestControllerAdvice(annotations = RestController.class)
public class LineupRestAdvice {

    private final Logger logger = LoggerFactory.getLogger(Lineup.class);

    @ResponseBody
    @ExceptionHandler({ValidationLineupException.class})
    public ResponseEntity<?> handleConditionException(ValidationLineupException ex) {
        logger.error(ex.getMessage());

        return ResponseEntity.status(UNPROCESSABLE_ENTITY)
                .body(new ResponseError(String.valueOf(UNPROCESSABLE_ENTITY.value()), ex.getMessage()));
    }

    @ResponseBody
    @ExceptionHandler({NotFoundLineupException.class})
    public ResponseEntity<?> handleNotFoundException(NotFoundLineupException ex) {
        logger.error(ex.getMessage());

        return ResponseEntity.status(NOT_FOUND)
                .body(new ResponseError(String.valueOf(NOT_FOUND.value()), ex.getMessage()));
    }

}
