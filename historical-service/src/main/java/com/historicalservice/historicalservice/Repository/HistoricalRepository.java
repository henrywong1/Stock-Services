package com.historicalservice.historicalservice.Repository;

import java.util.List;

import com.historicalservice.historicalservice.Entity.Historical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HistoricalRepository extends JpaRepository<Historical, Long> {

    @Query(value = "SELECT s FROM Historical s WHERE s.stockId = ?1")
    public List<Historical> getHistoricalDataByStockId(Long stockId);
}
