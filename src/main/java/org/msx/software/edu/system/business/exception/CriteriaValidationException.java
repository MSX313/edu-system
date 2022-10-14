package org.msx.software.edu.system.business.exception;

public class CriteriaValidationException extends ProcessException {

    public CriteriaValidationException(String message) {
        super(message);
    }

    public CriteriaValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CriteriaValidationException(String message, Object... params) {
        super(message, params);
    }

    public CriteriaValidationException(String message, Throwable cause, Object... params) {
        super(message, cause, params);
    }
}
