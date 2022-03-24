package com.reservoir.datareservoir.client.controller.cube;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.CubeDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cube/magnetic-field-z")
public class CubeMagneticFieldZController {

    @GetMapping
    public ModelAndView magneticFieldZ() {
        return new ModelAndView("cube/tabs/magneticFieldZ/magneticFieldZ");
    }

    @GetMapping("/table")
    public ModelAndView getMagneticFieldZTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/magneticFieldZ/table");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));

        return modelAndView;
    }

    @PostMapping("/table")
    public ModelAndView postMagneticFieldZTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/magneticFieldZ/table");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));

        return modelAndView;
    }

    @GetMapping("/graph")
    public ModelAndView getMagneticFieldZGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/magneticFieldZ/graph");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));

        return modelAndView;
    }

    @PostMapping("/graph")
    public ModelAndView postMagneticFieldZGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/magneticFieldZ/graph");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));
        return modelAndView;
    }
}
