package com.fmt.app.tutoring.utils;

import com.fmt.app.tutoring.models.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Util {
    public static ResponseEntity<?> getError(HttpStatus status, Exception e){
        ErrorModel error = ErrorModel.builder()
                .status(status)
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
