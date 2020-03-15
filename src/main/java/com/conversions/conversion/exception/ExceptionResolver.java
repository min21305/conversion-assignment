package com.conversions.conversion.exception;

import com.conversions.conversion.exception.model.InvalidEntryException;
import com.conversions.conversion.response.CalculationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice(basePackages = "com.conversions.conversion")
public class ExceptionResolver extends ResponseEntityExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(ExceptionResolver.class);

    @ExceptionHandler(value = {InvalidEntryException.class})
    private ResponseEntity<CalculationResponse> handleInvalidEntryException(InvalidEntryException ex) {
        return  ResponseEntity.badRequest().body(new CalculationResponse(ex.getErrorDetails(),0L));
    }
}
