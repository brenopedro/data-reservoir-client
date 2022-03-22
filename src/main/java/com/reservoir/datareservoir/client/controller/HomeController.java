package com.reservoir.datareservoir.client.controller;

import com.reservoir.datareservoir.client.config.auth.AuthorizationToken;
import com.reservoir.datareservoir.client.domain.model.CubeData;
import com.reservoir.datareservoir.client.domain.model.DroneData;
import com.reservoir.datareservoir.client.domain.model.RocketData;
import com.reservoir.datareservoir.client.domain.model.UrlEnum;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView home() throws InterruptedException {
        ModelAndView modelAndView = new ModelAndView("home");

        String accessToken = AuthorizationToken.getAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        var request = new HttpEntity(headers);
        ResponseEntity<CubeData[]> responseCube = new RestTemplate().exchange(UrlEnum.COLLECTION_CUBE.getUrl(),
                HttpMethod.GET, request, CubeData[].class);

        ResponseEntity<DroneData[]> responseDrone = new RestTemplate().exchange(UrlEnum.COLLECTION_DRONE.getUrl(),
                HttpMethod.GET, request, DroneData[].class);

        ResponseEntity<RocketData[]> responseRocket = new RestTemplate().exchange(UrlEnum.COLLECTION_ROCKET.getUrl(),
                HttpMethod.GET, request, RocketData[].class);


        modelAndView.addObject("cubeData", responseCube.getBody());
        modelAndView.addObject("droneData", responseDrone.getBody());
        modelAndView.addObject("rocketData", responseRocket.getBody());
        return modelAndView;
    }

}
