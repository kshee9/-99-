package com.sparta.myrest.model;

import com.sparta.myrest.dto.FoodsListResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Orders {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column (nullable = false)
    public String restaurantName;

    @Column (nullable = false)
    private int deliveryFee;

    @Column (nullable = false)
    private int totalPrice;


    @OneToMany
    @JoinColumn(name = "FOOD_ID")
    private List<FoodListorder> foods;

    public Orders(String restaurantName, List<FoodListorder> foodListorders, int deliveryFee, int totalPrice ) {
        this.restaurantName = restaurantName;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
        this.foods = foodListorders;
    }

}
