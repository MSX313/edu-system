package org.msx.software.edu.system.business.exception;

public class CommonException extends Exception {

    private Object[] parameters;

    public CommonException(String errorKey) {
        super(errorKey);
    }

    public CommonException(String errorKey, Object... params) {
        super(errorKey);
        setParameters(params);
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}