package com.dyuvarov.aviasales.controller;

import com.dyuvarov.aviasales.dao.*;
import com.dyuvarov.aviasales.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class FlightsController {
    private final FlightsDAO flightsDAO;

    @Autowired
    public FlightsController(FlightsDAO flightsDAO) {
        this.flightsDAO = flightsDAO;
    }

    @GetMapping("/{id}")
    public Flight findFlight(@PathVariable("id") String id) {
        return flightsDAO.flightById(id);
    }
}
