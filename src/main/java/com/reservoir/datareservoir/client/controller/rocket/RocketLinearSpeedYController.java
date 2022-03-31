package com.reservoir.datareservoir.client.controller.rocket;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.RocketDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rocket/linear-speed-y")
public class RocketLinearSpeedYController {

    @GetMapping
    public ModelAndView rocketLinearSpeedY() {
        return new ModelAndView("rocket/tabs/linearSpeedY/linearSpeedY");
    }

    @GetMapping("/table")
    public ModelAndView getRocketLinearSpeedYTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/linearSpeedY/table");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/table")
    public ModelAndView postRocketLinearSpeedYTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/linearSpeedY/table");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @GetMapping("/graph")
    public ModelAndView getRocketLinearSpeedYGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/linearSpeedY/graph");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/graph")
    public ModelAndView postRocketLinearSpeedYGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/linearSpeedY/graph");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }
}
