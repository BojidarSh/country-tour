package com.neighbours.countrytour.advice;

import com.neighbours.countrytour.response.ExceptionResponse;
import com.neighbours.countrytour.response.builder.ExceptionResponseBuilder;
import com.neighbours.countrytour.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Arrays;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handle(ConstraintViolationException exception,
                                    final HttpServletRequest request) {

        ExceptionResponse response = createExceptionResponse(request, exception.getMessage().split(", "));
        logger.error("Bad api method request parameters: {}.", response);

        return response;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle(UnknownHostException exception,
                                    final HttpServletRequest request) {

        ExceptionResponse response = createExceptionResponse(request, "Host: '" + exception.getMessage() + "' not found.");
        logger.error("Host: '{}' not found.", exception.getMessage());

        return response;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ExceptionResponse handle(MalformedURLException exception,
                                    final HttpServletRequest request) {

        ExceptionResponse response = createExceptionResponse(request, "No connection to gateway.");
        logger.error("MalformedURLException: '{}'.", exception.getMessage());

        return response;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ExceptionResponse handle(URISyntaxException exception,
                                    final HttpServletRequest request) {

        ExceptionResponse response = createExceptionResponse(request, "No connection to gateway.");
        logger.error("URISyntaxException: '{}'.", exception.getMessage());

        return response;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle(HttpClientErrorException exception,
                                    final HttpServletRequest request) {

        ExceptionResponse response = createExceptionResponse(request, "Not found.");
        logger.error("HttpClientErrorException: '{}'.", exception.getMessage());

        return response;
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handle(ConnectException exception,
                                    final HttpServletRequest request) {

        ExceptionResponse response = createExceptionResponse(request, exception.getMessage());
        logger.error("Connecting service failed: '{}'.", exception.getMessage());

        return response;
    }

    private ExceptionResponse createExceptionResponse(HttpServletRequest request, String... errors) {

        return new ExceptionResponseBuilder()
                .errorMessages(Arrays.asList(errors))
                .requestedURI(request.getRequestURI())
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .requestId(request.getParameter(Constants.Api.REQUEST_ID))
                .flowId(request.getParameter(Constants.Api.FLOW_ID))
                .build();
    }
}