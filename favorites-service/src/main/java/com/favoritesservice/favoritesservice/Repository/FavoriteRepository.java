package com.favoritesservice.favoritesservice.Repository;

import java.util.List;

import com.favoritesservice.favoritesservice.Entity.Favorite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    @Query(value = "SELECT s FROM Favorite s WHERE s.userId = ?1")
    public List<Favorite> getFavoritesByUserId(String userId);
}
