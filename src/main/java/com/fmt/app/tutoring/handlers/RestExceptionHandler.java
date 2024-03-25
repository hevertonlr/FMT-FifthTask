package com.fmt.app.tutoring.handlers;

import com.fmt.app.tutoring.models.ErrorModel;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.fmt.app.tutoring.utils.Util.getError;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handler(Exception e){
        return getError(HttpStatus.INTERNAL_SERVER_ERROR,e);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handler(DataIntegrityViolationException e){
        return getError(HttpStatus.BAD_REQUEST,e);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handler(NotFoundException e){
        return getError(HttpStatus.NOT_FOUND,e);
    }
}
