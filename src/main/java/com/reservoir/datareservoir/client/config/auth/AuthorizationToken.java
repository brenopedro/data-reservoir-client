package com.reservoir.datareservoir.client.config.auth;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.reservoir.datareservoir.client.domain.model.TokenModel;

public class AuthorizationToken {

    private static final String TOKEN_PATH = "http://localhost:8081/oauth/token";

    private static String accessToken;
    private static TokenModel tokenModel;

    public static String getAccessToken() {
        if (accessToken == null) {
            accessToken = getToken();
        }
        return accessToken;
    }

    public static String useRefreshToken() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "refresh_token");
        map.add("refresh_token", tokenModel.getRefresh_token());

        return getToken(map);
    }

    private static String getToken() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("username", "brenoAdmin");
        map.add("password", "123");

        return getToken(map);
    }

    private static String getToken(MultiValueMap<String, String> map) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin-client", "admin123");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<TokenModel> response = new RestTemplate().exchange(TOKEN_PATH, HttpMethod.POST, request,
                TokenModel.class);
        tokenModel = response.getBody();
        return tokenModel.getAccess_token();
    }
}
