package org.msx.software.edu.system.controller.util;

import lombok.extern.slf4j.Slf4j;
import org.msx.software.edu.system.business.dto.ResponseDto;
import org.msx.software.edu.system.business.exception.SecurityException;
import org.msx.software.edu.system.business.exception.*;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
@CrossOrigin
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler implements ErrorController {

    private final static String PATH = "/error";

    @RequestMapping(PATH)
    public void handleError(final HttpServletRequest request, final HttpServletResponse response) throws Throwable {
        throw (Throwable) request.getAttribute("javax.servlet.error.exception");
    }
    
    public String getErrorPath() {
        return PATH;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = ConstraintsValidationException.class)
    public ResponseDto constraintValidationException(ConstraintsValidationException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = CriteriaValidationException.class)
    public ResponseDto criteriaValidationException(CriteriaValidationException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseDto dataNotFoundValidationException(DataNotFoundException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception, HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = SecurityException.class)
    public ResponseDto securityException(SecurityException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception, HttpStatus.UNAUTHORIZED);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = ProcessException.class)
    public ResponseDto processException(ProcessException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseDto runtimeException(RuntimeException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ResponseDto exception(Exception exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception);
    }

    private ResponseDto buildResponse(Exception exception) {
        return ResponseDto.builder()
                .hasError(true).responseCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .responsePhrase(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).message(exception.getMessage())
                .messageCode("UNHANDLED_EXCEPTION").build();
    }

    private ResponseDto buildResponse(ProcessException exception, HttpStatus httpStatus) {
        return ResponseDto.builder()
                .hasError(true).responseCode(httpStatus.value()).responsePhrase(httpStatus.getReasonPhrase())
                .message(exception.getMessagePhrase()).messageCode(exception.getMessageCode()).build();
    }
}