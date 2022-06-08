package com.sparta.myrest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class OrderResponseDto {
    private  String restaurantName;
    private List<FoodsListResponseDto> foods;
    private int deliveryFee;
    private int totalPrice;


    public OrderResponseDto(String restaurantName, List<FoodsListResponseDto> foodsListResponseDto, int deliveryFee,  int totalPrice){
        this.restaurantName = restaurantName;
        this.foods =foodsListResponseDto;
        this.deliveryFee =deliveryFee;
        this.totalPrice =totalPrice;
    }
}
