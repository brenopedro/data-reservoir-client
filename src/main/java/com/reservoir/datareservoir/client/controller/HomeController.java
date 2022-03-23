package com.reservoir.datareservoir.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.CubeDataService;
import com.reservoir.datareservoir.client.domain.service.DroneDataService;
import com.reservoir.datareservoir.client.domain.service.RocketDataService;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ModelAndView getHome(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));
        modelAndView.addObject("droneData", DroneDataService.getDroneData(propertiesFilter));
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        
        return modelAndView;
    }
    
    @PostMapping
    public ModelAndView postHome(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));
        modelAndView.addObject("droneData", DroneDataService.getDroneData(propertiesFilter));
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        
        return modelAndView;
    }

}
