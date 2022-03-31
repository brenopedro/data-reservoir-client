package com.reservoir.datareservoir.client.controller.rocket;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.RocketDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rocket/magnetic-field-z")
public class RocketMagneticFieldZController {

    @GetMapping
    public ModelAndView magneticFieldZ() {
        return new ModelAndView("rocket/tabs/magneticFieldZ/magneticFieldZ");
    }

    @GetMapping("/table")
    public ModelAndView getMagneticFieldZTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/magneticFieldZ/table");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/table")
    public ModelAndView postMagneticFieldZTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/magneticFieldZ/table");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @GetMapping("/graph")
    public ModelAndView getMagneticFieldZGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/magneticFieldZ/graph");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/graph")
    public ModelAndView postMagneticFieldZGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("rocket/tabs/magneticFieldZ/graph");
        modelAndView.addObject("rocketData", RocketDataService.getRocketData(propertiesFilter));
        return modelAndView;
    }
}
