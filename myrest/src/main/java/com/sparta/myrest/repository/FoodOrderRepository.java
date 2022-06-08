package com.sparta.myrest.repository;

import com.sparta.myrest.model.Food;
import com.sparta.myrest.model.FoodListorder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodOrderRepository extends JpaRepository<FoodListorder,Long> {

}
