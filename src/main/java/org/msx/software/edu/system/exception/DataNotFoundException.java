package org.msx.software.edu.system.exception;

public class DataNotFoundException extends ProcessException {

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotFoundException(String message, Object... params) {
        super(message, params);
    }

    public DataNotFoundException(String message, Throwable cause, Object... params) {
        super(message, cause, params);
    }
}