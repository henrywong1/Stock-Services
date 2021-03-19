package com.Stocks.companyservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @GetMapping("/")
    public String Home() {
        return "Company Service";
    }

}
