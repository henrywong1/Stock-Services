package com.stock.stockservice.Controller;

import java.util.List;

import com.stock.stockservice.Entity.Stock;
import com.stock.stockservice.Repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    private StockRepository repository;

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return repository.findAll();
    }

    @GetMapping("/stocks/{symbol}")
    @ResponseBody
    public Stock getStockBySymbol(@PathVariable String symbol) {
        return repository.searchBySymbol(symbol);
    }

    @PostMapping("/stocks/add")
    @PreAuthorize("hasAuthority('admins')")
    public String saveStock(@RequestBody Stock newStock) {
        repository.save(newStock);
        return "Saved";

    }

}
