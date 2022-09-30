package org.msx.software.edu.system.util.codes;

public interface ExceptionMessageCode {

    // Generic util
    String PRS_NO_SUCH_METHOD_EXCEPTION = "PRS_NO_SUCH_METHOD_EXCEPTION";
    String PRS_ILLEGAL_ACCESS_EXCEPTION = "PRS_ILLEGAL_ACCESS_EXCEPTION";
    String PRS_INVOCATION_TARGET_EXCEPTION = "PRS_INVOCATION_TARGET_EXCEPTION";
    String PRS_INVOKE_ENUM_GENERAL_EXCEPTION = "PRS_INVOKE_ENUM_GENERAL_EXCEPTION";
    // AUTHENTICATION
    String AUTHENTICATION_FAILED = "AUTHENTICATION_FAILED";
    String TOKEN_INVALID = "TOKEN_INVALID";
    String TOKEN_EXPIRED = "TOKEN_EXPIRED";
    String USERNAME_NOT_FOUND = "USERNAME_NOT_FOUND";
    String USERNAME_NOT_FOUND_WITH_ID = "USERNAME_NOT_FOUND_WITH_ID";
    String USERNAME_NOT_FOUND_WITH_USERNAME = "USERNAME_NOT_FOUND_WITH_USERNAME";
}