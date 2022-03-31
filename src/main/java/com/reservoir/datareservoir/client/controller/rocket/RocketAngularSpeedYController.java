package com.reservoir.datareservoir.client.controller.rocket;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.RocketDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rocket/angular-speed-y")
public class RocketAngularSpeedYController {

    @GetMapping
    public ModelAndView rocketAngularSpeedY() {
        return new ModelAndView("rocket/tabs/angularSpeedY/angularSpeedY");
    }

    @GetMapping("/table")
    public ModelAndView getRocketAngularSpeedYTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/angularSpeedY/table");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/table")
    public ModelAndView postRocketAngularSpeedYTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/angularSpeedY/table");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @GetMapping("/graph")
    public ModelAndView getRocketAngularSpeedYGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/angularSpeedY/graph");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/graph")
    public ModelAndView postRocketAngularSpeedYGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/angularSpeedY/graph");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }
}
