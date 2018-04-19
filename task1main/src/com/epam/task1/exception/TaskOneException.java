package com.epam.task1.exception;

public class TaskOneException extends Exception {
    public TaskOneException() {
        super();
    }

    public TaskOneException(String message) {
        super(message);
    }

    public TaskOneException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskOneException(Throwable cause) {
        super(cause);
    }

    protected TaskOneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
