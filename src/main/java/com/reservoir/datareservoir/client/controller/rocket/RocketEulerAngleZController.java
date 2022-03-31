package com.reservoir.datareservoir.client.controller.rocket;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.RocketDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rocket/euler-angle-z")
public class RocketEulerAngleZController {

    @GetMapping
    public ModelAndView rocketEulerAngleZ() {
        return new ModelAndView("rocket/tabs/eulerAngleZ/eulerAngleZ");
    }

    @GetMapping("/table")
    public ModelAndView getRocketEulerAngleZTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/eulerAngleZ/table");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/table")
    public ModelAndView postRocketEulerAngleZTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/eulerAngleZ/table");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @GetMapping("/graph")
    public ModelAndView getRocketEulerAngleZGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/eulerAngleZ/graph");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/graph")
    public ModelAndView postRocketEulerAngleZGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/eulerAngleZ/graph");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }
}
