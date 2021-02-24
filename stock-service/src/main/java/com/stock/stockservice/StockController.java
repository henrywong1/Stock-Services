package com.stock.stockservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @GetMapping("/stocks")
    public String getStocks() {
        System.out.println("Testingg");
        return "TEST!";
    }
}
