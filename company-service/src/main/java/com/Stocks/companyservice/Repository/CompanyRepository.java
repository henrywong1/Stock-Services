package com.Stocks.companyservice.Repository;

import java.util.List;

import com.Stocks.companyservice.Entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query(value = "SELECT s FROM Company s WHERE s.stockId = ?1")
    public Company getCompanyByStockId(Long id);
}
