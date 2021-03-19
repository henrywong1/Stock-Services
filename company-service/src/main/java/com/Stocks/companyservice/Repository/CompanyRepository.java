package com.Stocks.companyservice.Repository;

import com.Stocks.companyservice.Entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
