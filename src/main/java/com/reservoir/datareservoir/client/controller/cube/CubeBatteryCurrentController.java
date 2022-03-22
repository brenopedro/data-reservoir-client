package com.reservoir.datareservoir.client.controller.cube;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.CubeDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cube/battery-current")
public class CubeBatteryCurrentController {

    @GetMapping
    public ModelAndView cubeBatteryCurrent() {
        return new ModelAndView("cube/tabs/batteryCurrent/batteryCurrent");
    }

    @GetMapping("/table")
    public ModelAndView getCubeBatteryCurrentTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/batteryCurrent/table");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));

        return modelAndView;
    }

    @PostMapping("/table")
    public ModelAndView postCubeBatteryCurrentTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/batteryCurrent/table");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));

        return modelAndView;
    }

    @GetMapping("/graph")
    public ModelAndView getCubeBatteryCurrentGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/batteryCurrent/graph");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));

        return modelAndView;
    }

    @PostMapping("/graph")
    public ModelAndView postCubeBatteryCurrentGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/batteryCurrent/graph");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));
        return modelAndView;
    }
}
