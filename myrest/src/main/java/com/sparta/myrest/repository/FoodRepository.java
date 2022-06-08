package com.sparta.myrest.repository;

import com.sparta.myrest.model.Food;
import com.sparta.myrest.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long > {

    Optional<Food> findFoodByRestaurantAndName(Restaurant restaurant, String foodName);

    List<Food> findFoodsByRestaurant(Restaurant restaurant);

    List<Food> findAllById(Long restaurantId);
}
