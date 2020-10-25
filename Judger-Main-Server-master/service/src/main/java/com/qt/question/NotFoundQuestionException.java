package com.qt.question;

public class NotFoundQuestionException extends RuntimeException {
    public NotFoundQuestionException() {
        super();
    }

    public NotFoundQuestionException(String message) {
        super(message);
    }
}
