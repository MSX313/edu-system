package org.msx.software.edu.system.business.exception;


import static org.msx.software.edu.system.business.util.MessageUtil.format;

public class ProcessException extends RuntimeException {

    private final String messageCode;
    private final String messagePhrase;
    private final Throwable cause;
    private final Object[] params;

    public ProcessException(String message) {
        super(message);
        this.messageCode = message;
        this.messagePhrase = format(message);
        this.cause = null;
        this.params = new Object[]{};
    }

    public ProcessException(String message, Throwable cause) {
        super(message, cause);
        this.messageCode = message;
        this.messagePhrase = format(message);
        this.cause = cause;
        this.params = new Object[]{};
    }

    public ProcessException(String message, Object... params) {
        super(message);
        this.messageCode = message;
        this.messagePhrase = format(message, params);
        this.cause = null;
        this.params = params;
    }

    public ProcessException(String message, Throwable cause, Object... params) {
        super(message, cause);
        this.messageCode = message;
        this.messagePhrase = format(message, params);
        this.cause = cause;
        this.params = params;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public String getMessagePhrase() {
        return messagePhrase;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public Object[] getParams() {
        return params;
    }
}