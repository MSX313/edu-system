package org.msx.software.edu.system.business.exception;

public class ConstraintsValidationException extends ProcessException {

    public ConstraintsValidationException(String message) {
        super(message);
    }

    public ConstraintsValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConstraintsValidationException(String message, Object... params) {
        super(message, params);
    }

    public ConstraintsValidationException(String message, Throwable cause, Object... params) {
        super(message, cause, params);
    }
}
