package com.qt.contest.apply;

public class NotFoundContestApplicationException extends RuntimeException {
    public NotFoundContestApplicationException() {
        super();
    }

    public NotFoundContestApplicationException(String message) {
        super(message);
    }
}
