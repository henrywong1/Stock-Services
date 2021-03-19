package com.historicalservice.historicalservice.Repository;

import com.historicalservice.historicalservice.Entity.Historical;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalRepository extends JpaRepository<Historical, Long> {

}
