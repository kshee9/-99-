package com.sparta.myrest.controller;

import com.sparta.myrest.dto.FoodRequestDto;
import com.sparta.myrest.model.Food;
import com.sparta.myrest.service.FoodService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {


    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }
    //음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void addFood(@RequestBody List<FoodRequestDto> foodRequestDto, @PathVariable Long restaurantId){
         foodService.addFood(foodRequestDto, restaurantId);
    }

    //메뉴판 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getMenu(@PathVariable Long restaurantId){

        return foodService.getMenu(restaurantId);
    }
}
