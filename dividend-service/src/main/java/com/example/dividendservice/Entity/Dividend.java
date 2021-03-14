package com.example.dividendservice.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Dividend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long stockid;
    private String frequency;
    private double amount;
    private LocalDate exDividendDate;
    private LocalDate declaredDate;
    private LocalDate paymentDate;
    private LocalDate lastUpdated;

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Long getStockid() {
        return stockid;
    }

    public void setStockid(Long stockid) {
        this.stockid = stockid;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getExDividendDate() {
        return exDividendDate;
    }

    public void setExDividendDate(LocalDate exDividendDate) {
        this.exDividendDate = exDividendDate;
    }

    public LocalDate getDeclaredDate() {
        return declaredDate;
    }

    public void setDeclaredDate(LocalDate declaredDate) {
        this.declaredDate = declaredDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

}
