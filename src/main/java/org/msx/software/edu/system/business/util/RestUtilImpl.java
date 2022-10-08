package org.msx.software.edu.system.business.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class RestUtilImpl implements RestUtil {

    @Override
    public <T> T get(String uri, Map<String, String> queryParams, Map<String, String> headers, Class<T> clazz) {
        return doRequest(uri, queryParams, headers, HttpMethod.GET, clazz);
    }

    @Override
    public <T> T post(String uri, Map<String, String> queryParams, Map<String, String> headers, Class<T> clazz) {
        return doRequest(uri, queryParams, headers, HttpMethod.POST, clazz);
    }

    @Override
    public <T> T post(String uri, MultiValueMap<String, String> formData, Map<String, String> headers, Class<T> clazz) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(uri);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        for (String key : headers.keySet()) {
            httpHeaders.add(key, headers.get(key));
        }
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(
                uriComponentsBuilder.build().encode().toUriString(), request, clazz).getBody();
    }

    private <T> T doRequest(
            String uri, Map<String, String> queryParams,
            Map<String, String> headers, HttpMethod method, Class<T> clazz) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(uri);
        for (String key : queryParams.keySet()) {
            uriComponentsBuilder = uriComponentsBuilder.queryParam(key, queryParams.get(key));
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        for (String key : headers.keySet()) {
            httpHeaders.add(key, headers.get(key));
        }
        HttpEntity request = new HttpEntity(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                uriComponentsBuilder.build().encode().toUriString(),
                method,
                request,
                clazz).getBody();
    }
}
