package org.msx.software.edu.system.business.operation.authentication;

import lombok.RequiredArgsConstructor;
import org.msx.software.edu.system.business.common.codes.ExceptionMessageCode;
import org.msx.software.edu.system.business.util.RestUtil;
import org.msx.software.edu.system.controller.mapper.UserViewModelMapper;
import org.msx.software.edu.system.controller.vm.UserEntityVm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PodOAuthService {

    private final UserViewModelMapper userViewModelMapper;
    private final RestUtil restUtil;
    @Value("${pod.ssoAddress}")
    private String ssoAddress;
    @Value("${pod.platformAddress}")
    private String platformAddress;
    @Value("${pod.clientId}")
    private String clientId;
    @Value("${pod.clientSecret}")
    private String clientSecret;
    @Value("${pod.tokenIssuer}")
    private String tokenIssuer;
    @Value("${pod.redirectUrl}")
    private String redirectUrl;
    @Value("${pod.userAccessTokenAddress}")
    private String userAccessTokenAddress;
    @Value("${pod.getUserProfileAddress}")
    private String getUserProfileAddress;

    public UserEntityVm getUser(String code) {
        return userViewModelMapper.map(getUserData(getUserAccessToken(code)));
    }

    public UserEntityVm getUserByBusinessToken(String tokenId) {
        return userViewModelMapper.map(getUserData(tokenId));
    }

    private Object getUserAccessToken(String code) {
        String url = String.format("%s/%s/", ssoAddress, userAccessTokenAddress);
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("grant_type", "authorization_code");
        queryParams.put("code", code);
        queryParams.put("redirect_uri", redirectUrl);
        queryParams.put("client_id", clientId);
        queryParams.put("client_secret", clientSecret);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return restUtil.post(url, queryParams, headers, Object.class);
    }

    private Object getUserData(Object userAccessToken) {
        return getUserData(((LinkedHashMap) userAccessToken).get("access_token").toString());
    }

    private Object getUserData(String tokenId) {
        String url = String.format("%s/%s/", platformAddress, getUserProfileAddress);
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id", clientId);
        queryParams.put("client_secret", clientSecret);
        Map<String, String> headers = new HashMap<>();
        headers.put("_token_", tokenId);
        headers.put("_token_issuer_", tokenIssuer);
        Object result = restUtil.get(url, queryParams, headers, Object.class);
        LinkedHashMap resultMap = (LinkedHashMap) result;
        if (Boolean.parseBoolean(resultMap.get("hasError").toString())) {
            throw new SecurityException(ExceptionMessageCode.AUTHENTICATION_FAILED);
        } else {
            return result;
        }
    }
}