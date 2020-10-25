package com.qt.contest;

public class NotFoundContestException extends RuntimeException {
    public NotFoundContestException() {
        super();
    }

    public NotFoundContestException(String message) {
        super(message);
    }
}
