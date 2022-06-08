package com.sparta.myrest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class FoodRequestDto {
    private String name;
    private int price;
}
