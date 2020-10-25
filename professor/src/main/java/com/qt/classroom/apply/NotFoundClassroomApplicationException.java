package com.qt.classroom.apply;

public class NotFoundClassroomApplicationException extends RuntimeException {
    public NotFoundClassroomApplicationException(){
        super();
    }

    public NotFoundClassroomApplicationException(String message)
    {
        super(message);
    }
}
