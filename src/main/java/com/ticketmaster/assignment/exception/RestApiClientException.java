package com.ticketmaster.assignment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestApiClientException extends RuntimeException {

    private String message;
    private String requestUrl;
}
