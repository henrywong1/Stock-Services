package com.stock.stockservice.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String symbol;

    private String name;

    private String img_url;

    private Double high52W;

    private Double low52W;

    private String sector;

    private Double last_price;

    // Should be String
    private String mkt_cap;

    private Double pe;

    public String getSymbol() {
        return symbol;
    }

    public Double getPe() {
        return pe;
    }

    public void setPe(Double pe) {
        this.pe = pe;
    }

    public String getMkt_cap() {
        return mkt_cap;
    }

    public void setMkt_cap(String mkt_cap) {
        this.mkt_cap = mkt_cap;
    }

    public Double getLast_price() {
        return last_price;
    }

    public void setLast_price(Double last_price) {
        this.last_price = last_price;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Double getLow52W() {
        return low52W;
    }

    public void setLow52W(Double low52w) {
        this.low52W = low52w;
    }

    public Double getHigh52W() {
        return high52W;
    }

    public void setHigh52W(Double high52w) {
        this.high52W = high52w;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
