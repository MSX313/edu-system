package org.msx.software.edu.system.business.util;

import org.springframework.util.MultiValueMap;

import java.util.Map;

public interface RestUtil {

    <T> T get(String uri, Map<String, String> queryParams, Map<String, String> headers, Class<T> clazz);

    <T> T post(String uri, Map<String, String> queryParams, Map<String, String> headers, Class<T> clazz);

    <T> T post(String uri, MultiValueMap<String, String> formData, Map<String, String> headers, Class<T> clazz);
}