package com.example.dividendservice.Repository;

import java.util.List;

import com.example.dividendservice.Entity.Dividend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DividendRepository extends JpaRepository<Dividend, Long> {

    @Query(value = "SELECT s FROM Dividend s WHERE s.stockid = ?1")
    public List<Dividend> getDividendByStockId(Long stockId);
}
