package com.sparta.myrest.model;

import com.sparta.myrest.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Food {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    public Food(FoodRequestDto foodRequestDto,Restaurant restaurant) {
        this.name = foodRequestDto.getName();
        this.price = foodRequestDto.getPrice();
        this.restaurant = restaurant;
    }
}
