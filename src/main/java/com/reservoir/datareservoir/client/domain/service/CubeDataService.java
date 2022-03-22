package com.reservoir.datareservoir.client.domain.service;

import com.reservoir.datareservoir.client.config.auth.AuthorizationToken;
import com.reservoir.datareservoir.client.domain.model.CubeData;
import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.model.UrlEnum;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

public class CubeDataService {

    public static CubeData[] getCubeData(PropertiesFilter propertiesFilter) {
        String accessToken = AuthorizationToken.getAccessToken();
        CubeData[] cubeData;

        Map<String, String> params = new HashMap<>();
        params.put("fromTimeStamp", propertiesFilter.getFromTimeStamp());
        params.put("toTimeStamp", propertiesFilter.getToTimeStamp());

        String uri = UriComponentsBuilder.fromHttpUrl(UrlEnum.COLLECTION_CUBE.getUrl())
                .queryParam("fromTimeStamp", "{fromTimeStamp}")
                .queryParam("toTimeStamp", "{toTimeStamp}")
                .encode().toUriString();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);

            var request = new HttpEntity(headers);

            cubeData = new RestTemplate().exchange(uri, HttpMethod.GET,
                            request, CubeData[].class, params).getBody();
        } catch (HttpClientErrorException e) {
            accessToken = AuthorizationToken.useRefreshToken();

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);

            var request = new HttpEntity(headers);

            cubeData = new RestTemplate().exchange(uri, HttpMethod.GET,
                    request, CubeData[].class, params).getBody();
        }


        return cubeData;
    }
}
