package com.reservoir.datareservoir.client.domain.service;

import com.reservoir.datareservoir.client.config.auth.AuthorizationToken;
import com.reservoir.datareservoir.client.domain.model.RocketData;
import com.reservoir.datareservoir.client.domain.model.UrlEnum;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class RocketDataService {

    public static RocketData[] getRocketData() {
        String accessToken = AuthorizationToken.getAccessToken();
        RocketData[] rocketData;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);

            var request = new HttpEntity(headers);

            rocketData = new RestTemplate().exchange(UrlEnum.COLLECTION_DRONE.getUrl(), HttpMethod.GET, request, RocketData[].class)
                    .getBody();
        } catch (HttpClientErrorException e) {
            accessToken = AuthorizationToken.useRefreshToken();

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);

            var request = new HttpEntity(headers);

            rocketData = new RestTemplate().exchange(UrlEnum.COLLECTION_DRONE.getUrl(), HttpMethod.GET, request, RocketData[].class)
                    .getBody();
        }

        return rocketData;
    }
}
