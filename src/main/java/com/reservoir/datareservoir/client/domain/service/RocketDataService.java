package com.reservoir.datareservoir.client.domain.service;

import com.reservoir.datareservoir.client.config.auth.AuthorizationToken;
import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.model.RocketData;
import com.reservoir.datareservoir.client.domain.model.UrlEnum;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RocketDataService {

    public static RocketData[] getRocketData(PropertiesFilter propertiesFilter) {
        String accessToken = AuthorizationToken.getAccessToken(false);
        RocketData[] rocketData;
        
        Map<String, String> params = new HashMap<>();
        params.put("fromTimeStamp", propertiesFilter.getFromTimeStamp());
        params.put("toTimeStamp", propertiesFilter.getToTimeStamp());

        String uri = UriComponentsBuilder.fromHttpUrl(UrlEnum.COLLECTION_ROCKET.getUrl())
                .queryParam("fromTimeStamp", "{fromTimeStamp}")
                .queryParam("toTimeStamp", "{toTimeStamp}")
                .encode().toUriString();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);

            var request = new HttpEntity(headers);

            rocketData = new RestTemplate().exchange(uri, HttpMethod.GET, 
            		request, RocketData[].class, params).getBody();
        } catch (HttpClientErrorException e) {
            accessToken = AuthorizationToken.getAccessToken(true);

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(accessToken);

            var request = new HttpEntity(headers);

            rocketData = new RestTemplate().exchange(uri, HttpMethod.GET, 
            		request, RocketData[].class, params).getBody();
        }

        return rocketData;
    }
}
