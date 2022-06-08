package com.sparta.myrest.model;

import com.sparta.myrest.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor  // 기본생성자 생략
@Entity     // db에 테이블 값
public class Restaurant {
    // 음식점 하나당 번호를 부여 ex) 1번의 id를 가진 음식점 청담동 쉐이크쉑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    // 음식점 이름
    @Column(nullable = false)
    private  String name ;
    // 음식점 최소 가격
    @Column(nullable = false)
    private  int minOrderPrice ;
    // 음식점 기본 배달료
    @Column(nullable = false)
    private  int deliveryFee;





    public  Restaurant(RestaurantRequestDto restaurantRequestDto){
        this.name = restaurantRequestDto.getName();
        this.minOrderPrice = restaurantRequestDto.getMinOrderPrice();
        this.deliveryFee = restaurantRequestDto.getDeliveryFee();
    }

}
