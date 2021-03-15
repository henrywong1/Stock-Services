package com.favoritesservice.favoritesservice.Repository;

import com.favoritesservice.favoritesservice.Entity.Favorite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

}
