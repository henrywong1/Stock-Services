package com.example.dividendservice.Controller;

import java.util.List;

import com.example.dividendservice.Entity.Dividend;
import com.example.dividendservice.Entity.Stock;
import com.example.dividendservice.Repository.DividendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class DividendController {

    @Autowired
    DividendRepository repository;

    @Autowired
    WebClient.Builder webClientBuilder;

    @GetMapping("/")
    public String home() {
        return "Dividend service";
    }

    @GetMapping("/dividends")
    public List<Dividend> test() {
        return repository.findAll();
    }

    @GetMapping("/dividends/{symbol}")
    @ResponseBody
    public List<Dividend> getDividendBySymbol(@PathVariable String symbol) {
        Stock stock = webClientBuilder.build().get().uri("lb://stock-service/stocks/" + symbol).retrieve()
                .bodyToMono(Stock.class).block();
        return repository.getDividendByStockId(stock.getId());
    }

    @PostMapping("/dividends/add")
    @PreAuthorize("hasAuthority('admins')")
    public Dividend saveDividend(@RequestBody Dividend dividend) {
        return repository.save(dividend);
    }
}
