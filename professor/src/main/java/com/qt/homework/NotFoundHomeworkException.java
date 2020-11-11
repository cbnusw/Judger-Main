package com.qt.homework;

public class NotFoundHomeworkException extends RuntimeException{
    public NotFoundHomeworkException()
    {
        super();
    }

    public NotFoundHomeworkException(String message)
    {
        super(message);
    }


}
