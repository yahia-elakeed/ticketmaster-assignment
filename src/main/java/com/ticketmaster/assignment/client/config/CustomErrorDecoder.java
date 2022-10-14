package com.ticketmaster.assignment.client.config;

import com.ticketmaster.assignment.exception.RestApiClientException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomErrorDecoder implements ErrorDecoder {

    private static final String ERROR_MSG_CLIENT_SERVER_ERROR = "Client server error.";

    @Override
    public Exception decode(String methodKey, Response response) {
        String requestUrl = response.request().url();
        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

        if (responseStatus.is5xxServerError()) {
            return new RestApiClientException(requestUrl, ERROR_MSG_CLIENT_SERVER_ERROR);
        } else if (responseStatus.is4xxClientError()) {
            return new RestApiClientException(requestUrl, ERROR_MSG_CLIENT_SERVER_ERROR);
        } else {
            return new Exception("Generic exception");
        }
    }
}