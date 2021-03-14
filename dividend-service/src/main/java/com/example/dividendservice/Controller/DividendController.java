package com.example.dividendservice.Controller;

import com.example.dividendservice.Entity.Dividend;
import com.example.dividendservice.Repository.DividendRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DividendController {

    @Autowired
    DividendRepository repository;

    @GetMapping("/dividends")
    public String test() {
        return "Dividend Service";
    }

    @GetMapping("/dividends/{symbol}")
    @ResponseBody
    public String getBySymbol(@PathVariable("symbol") String symbol) {
        // Feign client use Stock service get stock by ID, then get id.
        return "GETTING DIVIDEND DATA FOR" + symbol;
    }

    @PostMapping("/dividends")
    @PreAuthorize("hasAuthority('admins')")
    public Dividend saveDividend(@RequestBody Dividend newDividend) {
        return repository.save(newDividend);
    }

}
