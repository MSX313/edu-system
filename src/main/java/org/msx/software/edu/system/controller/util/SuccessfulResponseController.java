package org.msx.software.edu.system.controller.util;

import org.jetbrains.annotations.NotNull;
import org.msx.software.edu.system.business.dto.ResponseDto;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class SuccessfulResponseController implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(
            @NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(
            Object body, @NotNull MethodParameter methodParameter,
            @NotNull MediaType selectedContentType,
            @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NotNull ServerHttpRequest request,
            @NotNull ServerHttpResponse response) {
        if (body instanceof ResponseDto && ((ResponseDto) body).isHasError()) {
            return body;
        }
        if (methodParameter.getContainingClass().isAnnotationPresent(RestController.class)) {
            if (!Objects.requireNonNull(methodParameter.getMethod()).isAnnotationPresent(IgnoreResponseBinding.class)) {
                int length = 1;
                if (body == null) {
                    length = 0;
                } else if (body instanceof Collection) {
                    length = ((Collection<?>) body).size();
                } else if (body instanceof Map) {
                    length = ((Map<?, ?>) body).size();
                }
                return ResponseDto
                        .builder()
                        .hasError(false)
                        .responseCode(HttpStatus.OK.value())
                        .responsePhrase(HttpStatus.OK.getReasonPhrase())
                        .length(length)
                        .result(body)
                        .build();
            }
        }
        return body;
    }
}