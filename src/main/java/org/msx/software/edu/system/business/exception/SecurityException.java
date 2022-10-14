package org.msx.software.edu.system.business.exception;

public class SecurityException extends ProcessException {

    public SecurityException(String message) {
        super(message);
    }

    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityException(String message, Object... params) {
        super(message, params);
    }

    public SecurityException(String message, Throwable cause, Object... params) {
        super(message, cause, params);
    }
}