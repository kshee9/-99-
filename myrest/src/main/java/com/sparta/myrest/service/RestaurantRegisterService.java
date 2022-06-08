package com.sparta.myrest.service;

import com.sparta.myrest.dto.RestaurantRequestDto;
import com.sparta.myrest.model.Restaurant;
import com.sparta.myrest.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantRegisterService {

    private final RestaurantRepository restaurantRepository;



    // 음식점 등록하기 위해 controller로 넘겨줄 메소드 생성
    @Transactional
    public Restaurant register(RestaurantRequestDto restaurantRequestDto){

        if (restaurantRequestDto.getMinOrderPrice() % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력해 주세요");
        } else if (restaurantRequestDto.getMinOrderPrice() < 1000 || restaurantRequestDto.getMinOrderPrice() > 100000) {
            throw new IllegalArgumentException("주문 가격은 1,000~ 100,000원 입니다.");
        }
        if (restaurantRequestDto.getDeliveryFee() < 0 || restaurantRequestDto.getDeliveryFee() > 10000) {
            throw new IllegalArgumentException("기본 배달비는 0원 이상 10,000원 이하입니다.");
        }
        else if (restaurantRequestDto.getDeliveryFee() % 500 != 0) {
            throw new IllegalArgumentException("요금 단위는 500원 단위입니다. 다시 설정해주세요.");
        }
        Restaurant restaurant = new Restaurant(restaurantRequestDto);
         return restaurantRepository.save(restaurant);

    }
    // 음식점 전체 조회
    public List<Restaurant> getRestaurant(){
        return restaurantRepository.findAll();
    }
}
