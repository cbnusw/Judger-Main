package com.qt.problem;

public class NotFoundProblemException extends RuntimeException {
    public NotFoundProblemException() {
        super();
    }

    public NotFoundProblemException(String message) {
        super(message);
    }
}
