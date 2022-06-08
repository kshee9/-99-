package com.sparta.myrest.repository;

import com.sparta.myrest.model.Food;
import com.sparta.myrest.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long>{
}
