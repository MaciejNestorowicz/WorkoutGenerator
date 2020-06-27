package org.bitbucket.macko9909.workout.exception;

import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingRequestCookieException.class)
    public String CookieExceptionHandler() {
        return "error_page";
    }
}
