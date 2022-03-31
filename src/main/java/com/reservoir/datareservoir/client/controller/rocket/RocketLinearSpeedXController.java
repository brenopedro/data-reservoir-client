package com.reservoir.datareservoir.client.controller.rocket;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.RocketDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rocket/linear-speed-x")
public class RocketLinearSpeedXController {

    @GetMapping
    public ModelAndView rocketLinearSpeedX() {
        return new ModelAndView("rocket/tabs/linearSpeedX/linearSpeedX");
    }

    @GetMapping("/table")
    public ModelAndView getRocketLinearSpeedXTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/linearSpeedX/table");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/table")
    public ModelAndView postRocketLinearSpeedXTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/linearSpeedX/table");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @GetMapping("/graph")
    public ModelAndView getRocketLinearSpeedXGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/linearSpeedX/graph");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/graph")
    public ModelAndView postRocketLinearSpeedXGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/linearSpeedX/graph");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }
}
