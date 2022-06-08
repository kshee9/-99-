package com.sparta.myrest.service;

import com.sparta.myrest.dto.FoodRequestDto;
import com.sparta.myrest.model.Food;
import com.sparta.myrest.model.Restaurant;
import com.sparta.myrest.repository.FoodRepository;
import com.sparta.myrest.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository,RestaurantRepository restaurantRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }
    // 음식 등록
    @Transactional
    public void addFood(List<FoodRequestDto> foodRequestDto, Long restaurantId){

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);


        for (FoodRequestDto requestDto : foodRequestDto) {
            // 중복체크를 위한 음식값 가져오기
            String foodName = requestDto.getName();
            //음식값 설정하기 위해 값 가져오기
            int foodPrice = requestDto.getPrice();
           // 푸드 중복 체크
            checkFoodName(restaurant, foodName);
            //음식값 체크
            checkFoodPrice(foodPrice);
            Food food = new Food(requestDto, restaurant);
            foodRepository.save(food);
        }
    }

    private  void  checkFoodName(Restaurant restaurant , String foodName){
    Optional<Food> findfood = foodRepository.findFoodByRestaurantAndName(restaurant,foodName);
    if(findfood.isPresent()){
        throw  new IllegalArgumentException("중복된 음식이름이 존재합니다");
        }
    }

    private void checkFoodPrice(int foodPrice) {
        if (foodPrice < 100 ||foodPrice > 1_000_000)
            throw new IllegalArgumentException("허용되지 않는 값입니다.");

        if (foodPrice % 100 > 0)
            throw new IllegalArgumentException("100원 단위로만 입력이 가능합니다다");
   }


    // 메뉴판 조회
    @Transactional
    public List<Food> getMenu(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(
                        () -> new NullPointerException("존재하지않는 음식점입니다."));

        return foodRepository.findFoodsByRestaurant(restaurant);
    }


}
