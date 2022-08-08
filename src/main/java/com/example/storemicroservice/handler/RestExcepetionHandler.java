package com.example.storemicroservice.handler;

import com.example.storemicroservice.exception.ResourceNotFoundDetails;
import com.example.storemicroservice.exception.ResourceNotFoundException;
import java.time.LocalDateTime;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExcepetionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResourceNotFoundDetails> handlerBadRequestException(NotFoundException rnfe){
        return new ResponseEntity<>(
                ResourceNotFoundDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .develperMessage(rnfe.getClass().getName())
                        .title("Bad Request Exception, Check the Documentation.")
                        .status(HttpStatus.NOT_FOUND.value())
                        .detail(rnfe.getMessage())
                        .build(), HttpStatus.NOT_FOUND
        );
    }
}
