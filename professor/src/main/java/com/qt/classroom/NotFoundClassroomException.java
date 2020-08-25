package com.qt.classroom;

public class NotFoundClassroomException extends RuntimeException {
    public NotFoundClassroomException() {
        super();
    }

    public NotFoundClassroomException(String message) {
        super(message);
    }

}