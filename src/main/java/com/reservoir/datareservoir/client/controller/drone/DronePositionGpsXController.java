package com.reservoir.datareservoir.client.controller.drone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.DroneDataService;

@Controller
@RequestMapping("/drone/position-gps-x")
public class DronePositionGpsXController {

    @GetMapping
    public ModelAndView dronePositionGpsX() {
        return new ModelAndView("drone/tabs/positionGpsX/positionGpsX");
    }

    @GetMapping("/table")
    public ModelAndView getDronePositionGpsXTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("drone/tabs/positionGpsX/table");
        modelAndView.addObject("droneData", DroneDataService.getDroneData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/table")
    public ModelAndView postDronePositionGpsXTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("drone/tabs/positionGpsX/table");
        modelAndView.addObject("droneData", DroneDataService.getDroneData(propertiesFilter));
        return modelAndView;
    }

    @GetMapping("/graph")
    public ModelAndView getDronePositionGpsXGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("drone/tabs/positionGpsX/graph");
        modelAndView.addObject("droneData", DroneDataService.getDroneData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/graph")
    public ModelAndView postDronePositionGpsXGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("drone/tabs/positionGpsX/graph");
        modelAndView.addObject("droneData", DroneDataService.getDroneData(propertiesFilter));
        return modelAndView;
    }
}
