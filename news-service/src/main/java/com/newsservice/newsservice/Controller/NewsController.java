package com.newsservice.newsservice.Controller;

import java.util.List;

import com.newsservice.newsservice.Entity.News;
import com.newsservice.newsservice.Entity.Stock;
import com.newsservice.newsservice.Repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class NewsController {
    // Inject instance of WebClient Builder
    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    NewsRepository repository;

    @GetMapping("/")
    public String home() {
        return "News Service";
    }

    @GetMapping("/news/{symbol}")
    public List<News> getNews(@PathVariable String symbol) {
        // Gives instance of stock
        Stock stock = webClientBuilder.build().get().uri("lb://stock-service/stocks/" + symbol).retrieve()
                .bodyToMono(Stock.class).block();
        return repository.getNewsByStockId(stock.getId()); // -> Custom Query to search by stock
    }

    @PostMapping("/news/add")
    @PreAuthorize("hasAuthority('admins')")
    public News addNews(@RequestBody News news) {
        return repository.save(news);
    }
}
