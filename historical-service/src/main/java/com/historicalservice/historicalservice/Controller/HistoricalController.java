package com.historicalservice.historicalservice.Controller;

import java.util.List;

import com.historicalservice.historicalservice.Entity.Historical;
import com.historicalservice.historicalservice.Entity.Stock;
import com.historicalservice.historicalservice.Repository.HistoricalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class HistoricalController {

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    HistoricalRepository repository;

    @GetMapping("/")
    public String home() {
        return "Historical Service";
    }

    @GetMapping("/historical/{symbol}")
    public List<Historical> getHistoricalData(@PathVariable String symbol) {
        Stock stock = webClientBuilder.build().get().uri("lb://stock-service/stocks/" + symbol).retrieve()
                .bodyToMono(Stock.class).block();
        return repository.getHistoricalDataByStockId(stock.getId()); //
    }

    @PostMapping("/historical/add")
    @PreAuthorize("hasAuthority('admins')")
    public Historical saveNewHistorical(@RequestBody Historical historical) {
        return repository.save(historical);
    }
}
