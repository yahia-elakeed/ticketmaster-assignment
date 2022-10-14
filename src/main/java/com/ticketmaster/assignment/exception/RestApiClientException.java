package com.ticketmaster.assignment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestApiClientException extends RuntimeException {

    private final String message;
    private final String requestUrl;
}
