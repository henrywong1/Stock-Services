package com.favoritesservice.favoritesservice.Controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import com.favoritesservice.favoritesservice.Entity.Favorite;
import com.favoritesservice.favoritesservice.Repository.FavoriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoritesController {

    @Autowired
    FavoriteRepository repository;

    @GetMapping("/")
    public String baseCall() {
        return "Called Favorites Service";
    }

    // Todo: Research getting Okta user and storing userId in a non string form such
    // as an Int
    @GetMapping("/favorites")
    public List<Favorite> getFavorites(Principal principal) {
        System.out.println("Getting Favorites for: " + principal.getName());
        return repository.findAll();
    }

    @PostMapping("/favorites/add/{symbol}")
    @ResponseBody
    public Favorite addFavoriteStock(@PathVariable String symbol, Principal principal) {
        // Todo: Use Feign for access to stock service, call stock service to return id
        Favorite favorite = new Favorite();
        // favorite.setStockId(Integer.toUnsignedLong(1));
        favorite.setUserId(principal.getName());
        favorite.setTimestamp(LocalDate.now());
        return repository.save(favorite);
    }

}
