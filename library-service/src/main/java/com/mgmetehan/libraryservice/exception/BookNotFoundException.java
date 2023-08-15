package com.mgmetehan.libraryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {
    private ExceptionMessage exceptionMessage;

    public BookNotFoundException(String s) {
        super(s);
    }

    public BookNotFoundException(ExceptionMessage message) {
        this.exceptionMessage = message;
    }

    public BookNotFoundException(String message, ExceptionMessage exceptionMessage) {
        super(message);
        this.exceptionMessage = exceptionMessage;
    }

    public ExceptionMessage getExceptionMessage() {
        return exceptionMessage;
    }

}