package com.baywa.powerDataAPI.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PowerDataNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PowerDataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(PowerDataNotFoundException ex) {
        return ex.getMessage();
    }

}
