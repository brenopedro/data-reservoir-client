package com.reservoir.datareservoir.client.controller.cube;

import com.reservoir.datareservoir.client.domain.model.PropertiesFilter;
import com.reservoir.datareservoir.client.domain.service.CubeDataService;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
@RequestMapping("/cube/euler-angle-y")
public class CubeEulerAngleYController {

	private final CubeDataService cubeDataService;
	
    @GetMapping
    public ModelAndView cubeEulerAngleY() {
        return new ModelAndView("cube/tabs/eulerAngleY/eulerAngleY");
    }

    @GetMapping("/table")
    public ModelAndView getCubeEulerAngleYTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/eulerAngleY/table");
        modelAndView.addObject("cubeData", cubeDataService.getCubeData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/table")
    public ModelAndView postCubeEulerAngleYTable(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/eulerAngleY/table");
        modelAndView.addObject("cubeData", cubeDataService.getCubeData(propertiesFilter));
        return modelAndView;
    }

    @GetMapping("/graph")
    public ModelAndView getCubeEulerAngleYGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/eulerAngleY/graph");
        modelAndView.addObject("cubeData", cubeDataService.getCubeData(propertiesFilter));
        return modelAndView;
    }

    @PostMapping("/graph")
    public ModelAndView postCubeEulerAngleYGraph(PropertiesFilter propertiesFilter) {
        ModelAndView modelAndView = new ModelAndView("cube/tabs/eulerAngleY/graph");
        modelAndView.addObject("cubeData", cubeDataService.getCubeData(propertiesFilter));
        return modelAndView;
    }
}
