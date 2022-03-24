package com.reservoir.datareservoir.client.controller.cube;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.CubeDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cube/magnetic-field-y")
public class CubeMagneticFieldYController {

    @GetMapping
    public ModelAndView magneticFieldY() {
        return new ModelAndView("cube/tabs/magneticFieldY/magneticFieldY");
    }

    @GetMapping("/table")
    public ModelAndView getMagneticFieldYTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/magneticFieldY/table");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/table")
    public ModelAndView postMagneticFieldYTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/magneticFieldY/table");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));
        return modelAndView;
    }

    @GetMapping("/graph")
    public ModelAndView getMagneticFieldYGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/magneticFieldY/graph");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/graph")
    public ModelAndView postMagneticFieldYGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/magneticFieldY/graph");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));
        return modelAndView;
    }
}
