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

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/")
public class HomeController {
	
	private final CubeDataService cubeDataService;
	private final DroneDataService droneDataService;
	private final RocketDataService rocketDataService;

    @GetMapping
    public ModelAndView getHome(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("cubeData", cubeDataService.getCubeData(propertiesFilter));
        modelAndView.addObject("droneData", droneDataService.getDroneData(propertiesFilter));
        modelAndView.addObject("rocketData", rocketDataService.getRocketData(propertiesFilter));
        
        return modelAndView;
    }
    
    @PostMapping
    public ModelAndView postHome(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("cubeData", cubeDataService.getCubeData(propertiesFilter));
        modelAndView.addObject("droneData", droneDataService.getDroneData(propertiesFilter));
        modelAndView.addObject("rocketData", rocketDataService.getRocketData(propertiesFilter));
        
        return modelAndView;
    }

    @GetMapping("error")
    public ModelAndView handleError() {
        ModelAndView modelAndView = new ModelAndView("/error/error");
        return modelAndView;
    }

}
