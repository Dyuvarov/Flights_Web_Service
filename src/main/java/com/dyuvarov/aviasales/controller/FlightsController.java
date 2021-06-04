package com.dyuvarov.aviasales.controller;

import com.dyuvarov.aviasales.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flights")
public class FlightsController {

    private final FlightsDAO flightsDAO;

    @Autowired
    FlightsController (FlightsDAO flightsDAO) { this.flightsDAO = flightsDAO; }
}
