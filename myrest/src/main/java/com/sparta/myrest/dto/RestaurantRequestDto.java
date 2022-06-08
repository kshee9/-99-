package com.sparta.myrest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RestaurantRequestDto {

    // 음식점 이름
    private  String name ;
    // 음식점 최소 가격
    private  int minOrderPrice ;
    // 음식점 기본 배달료
    private  int deliveryFee;

}
