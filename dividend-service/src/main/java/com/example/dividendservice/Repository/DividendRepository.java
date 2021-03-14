package com.example.dividendservice.Repository;

import com.example.dividendservice.Entity.Dividend;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DividendRepository extends JpaRepository<Dividend, Long> {

}
