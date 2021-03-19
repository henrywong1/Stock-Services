package com.newsservice.newsservice.Repository;

import java.util.List;

import com.newsservice.newsservice.Entity.News;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewsRepository extends JpaRepository<News, Long> {

    @Query(value = "SELECT s FROM News s WHERE s.stockId = ?1")
    public List<News> getNewsByStockId(Long stockId);
}
