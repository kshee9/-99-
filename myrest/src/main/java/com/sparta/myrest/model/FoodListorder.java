package com.sparta.myrest.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class FoodListorder {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private int price;

    @Column (nullable = false)
    private int quantity;

    public FoodListorder(String name,int price, int quantity) {
        this.name =name;
        this.price = price;
        this.quantity = quantity;
    }

}