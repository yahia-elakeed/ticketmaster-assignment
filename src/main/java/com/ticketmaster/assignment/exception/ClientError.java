package com.ticketmaster.assignment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ClientError {

    private LocalDateTime errorDateTime;
    private String errorMessage;
    private String description;
    private String requestUrl;


}
