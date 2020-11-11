package com.qt.user;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException() {
        super();
    }

    public NotFoundUserException(String message) {
        super(message);
    }
}
