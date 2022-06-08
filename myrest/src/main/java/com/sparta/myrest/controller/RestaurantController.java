package com.sparta.myrest.controller;


import com.sparta.myrest.dto.RestaurantRequestDto;
import com.sparta.myrest.model.Restaurant;

import com.sparta.myrest.service.RestaurantRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantRegisterService restaurantRegisterService;



    // 가게 등록
    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantRequestDto requestDto){
        return restaurantRegisterService.register(requestDto);
    }

    // 가게 전체 조회
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantRegisterService.getRestaurant();
    }

}
