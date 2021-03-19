package com.historicalservice.historicalservice.Controller;

import com.historicalservice.historicalservice.Entity.Historical;
import com.historicalservice.historicalservice.Repository.HistoricalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoricalController {

    @Autowired
    HistoricalRepository repository;

    @GetMapping("/")
    public String home() {
        return "Historical Service";
    }

    @GetMapping("/historical/{symbol}")
    public Historical getHistoricalData(@PathVariable String symbol) {

        // WebClient builder -<

        return repository.getOne(1L);
    }

}
