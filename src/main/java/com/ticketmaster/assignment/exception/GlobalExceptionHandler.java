package com.ticketmaster.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final  String ERROR_CONNECT_TO_TM_SERVER = "Error while trying to connect to ticketmaster server!";
    private static final  String ERROR_COMPLETE_REQUEST = "Error while trying to complete the request!";

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ClientError> handleException(Exception exception) {

        ClientError clientError;

        if (exception instanceof RestApiClientException restApiClientException) {

            clientError = new ClientError(LocalDateTime.now(),
                    restApiClientException.getRequestUrl(),
                    ERROR_CONNECT_TO_TM_SERVER,
                    restApiClientException.getMessage());
        } else {

            clientError = new ClientError(LocalDateTime.now(),
                    "",
                    ERROR_COMPLETE_REQUEST,
                    exception.getMessage());
        }

        return new ResponseEntity<>(clientError, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ResourceNotFoundException> handleException(ResourceNotFoundException resourceNotFoundException) {
        throw  resourceNotFoundException;
    }
}
