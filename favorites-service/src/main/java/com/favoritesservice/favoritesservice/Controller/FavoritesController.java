package com.favoritesservice.favoritesservice.Controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import com.favoritesservice.favoritesservice.Entity.Favorite;
import com.favoritesservice.favoritesservice.Entity.Stock;
import com.favoritesservice.favoritesservice.Repository.FavoriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class FavoritesController {

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    FavoriteRepository repository;

    @GetMapping("/")
    public String home() {
        return "Favorites Service";
    }

    @GetMapping("/favorites")
    public List<Favorite> getFavorites(Principal principal) {
        System.out.println("Getting Favorites for: " + principal.getName());
        return repository.getFavoritesByUserId(principal.getName());
    }

    @PostMapping("/favorites/{symbol}")
    public Favorite addFavoriteStock(@PathVariable String symbol, Principal principal) {
        Stock stock = webClientBuilder.build().get().uri("lb://stock-service/stocks/" + symbol).retrieve()
                .bodyToMono(Stock.class).block();
        Favorite favorite = new Favorite();
        favorite.setStockId(stock.getId());
        favorite.setUserId(principal.getName());
        favorite.setTimestamp(LocalDate.now());
        return repository.save(favorite);
    }

}
