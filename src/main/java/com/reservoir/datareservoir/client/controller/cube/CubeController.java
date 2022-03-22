package com.reservoir.datareservoir.client.controller.cube;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.CubeDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cube")
public class CubeController {

    @GetMapping
    public ModelAndView getCube(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/cubeHome");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));

        return modelAndView;
    }

    @PostMapping
    public ModelAndView postCube(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/cubeHome");
        modelAndView.addObject("cubeData", CubeDataService.getCubeData(propertiesFilter));

        return modelAndView;
    }
}
