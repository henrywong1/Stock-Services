package com.Stocks.companyservice.Controller;

import java.util.List;

import com.Stocks.companyservice.Entity.Company;
import com.Stocks.companyservice.Entity.Stock;
import com.Stocks.companyservice.Repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class CompanyController {

    @Autowired
    CompanyRepository repository;

    @Autowired
    WebClient.Builder webClientBuilder;

    @GetMapping("/company")
    public String Home() {
        return "Company Service";
    }

    @GetMapping("/company/{symbol}")
    public Company getCompanyByStockSymbol(@PathVariable String symbol, @AuthenticationPrincipal Jwt jwt) {

        Stock stock = webClientBuilder.build().get().uri("lb://stock-service/stocks/" + symbol)
                .header("Authorization", "Bearer " + jwt.getTokenValue()).retrieve().bodyToMono(Stock.class).block();

        return repository.getCompanyByStockId(stock.getId());

    }

    @PostMapping("/company")
    @PreAuthorize("hasAuthority('admins')")
    public Company addCompanyInfo(@RequestBody Company company) {
        return repository.save(company);
    }

}
