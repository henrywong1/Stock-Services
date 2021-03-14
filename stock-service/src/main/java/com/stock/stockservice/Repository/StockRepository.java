package com.stock.stockservice.Repository;

import com.stock.stockservice.Entity.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query(value = "SELECT s FROM Stock s WHERE s.symbol = ?1")
    public Stock searchBySymbol(String symbol);
}
