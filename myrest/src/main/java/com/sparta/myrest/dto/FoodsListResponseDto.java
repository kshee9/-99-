package com.sparta.myrest.dto;


import com.sparta.myrest.model.FoodListorder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FoodsListResponseDto {
    private String name;
    private int quantity;
    private int price;


    public  FoodsListResponseDto (String name, int quantity , int price){
        this.name = name;
        this.quantity =quantity;
        this.price =price;

    }


}
