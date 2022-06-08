package com.sparta.myrest.service;

import com.sparta.myrest.dto.*;
import com.sparta.myrest.model.Food;
import com.sparta.myrest.model.FoodListorder;
import com.sparta.myrest.model.Orders;
import com.sparta.myrest.model.Restaurant;
import com.sparta.myrest.repository.FoodOrderRepository;
import com.sparta.myrest.repository.FoodRepository;
import com.sparta.myrest.repository.OrdersRepository;
import com.sparta.myrest.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;
    private final RestaurantRepository restaurantRepository;

    private final FoodRepository foodRepository;
    private final FoodOrderRepository foodOrderRepository;


    @Autowired
    public OrderService(OrdersRepository ordersRepository,
                        RestaurantRepository restaurantRepository,
                        FoodRepository foodRepository,
                        FoodOrderRepository foodOrderRepository
    ) {
        this.ordersRepository = ordersRepository;
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
        this.foodOrderRepository = foodOrderRepository;
    }


    // 주문 요청하기
    @Transactional
    public OrderResponseDto addOrder(OrderRequestDto orderRequestDto) {
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElseThrow(
                () -> new NullPointerException("가게가 존재하지않습니다")
        );
        String restaurantName = restaurant.getName();
        int deliveryFee = restaurant.getDeliveryFee();
        int totalprice = 0;
        //응답용
        List<FoodsListResponseDto> foodsListResponseDtos = new ArrayList<>();

        //db저장용
        List<FoodListorder> foodListorders = new ArrayList<>();

        for (FoodsListDto foodsListDto : orderRequestDto.getFoods()) {
            Food food = foodRepository.findById(foodsListDto.getId()).orElseThrow(
                    () -> new NullPointerException("존재하지않습니다.")
            );

            String name = food.getName();
            int quantity = foodsListDto.getQuantity();
            int price = food.getPrice() * quantity;

            totalprice += price;
            if (quantity < 1 || quantity > 100) {
                throw new NullPointerException("허용된 수량이 아닙니다.");
            }
            FoodListorder foodListorder = new FoodListorder(name, price, quantity);
            foodOrderRepository.save(foodListorder);
            foodListorders.add(foodListorder);

            FoodsListResponseDto foodsListResponseDto = new FoodsListResponseDto(name, quantity, price);
            foodsListResponseDtos.add(foodsListResponseDto);


        }
        if (totalprice < restaurant.getMinOrderPrice()) {
            throw new NullPointerException("주문할 음식을 더골라주세요");
        }
        totalprice += deliveryFee;
        Orders orders = new Orders(restaurantName, foodListorders, deliveryFee, totalprice);

        ordersRepository.save(orders);

        OrderResponseDto orderResponseDto = new OrderResponseDto(restaurantName, foodsListResponseDtos, deliveryFee, totalprice);

        return orderResponseDto;

    }
    // 주문 조회
//    public  List<Orders> getOrders(){
//        return ordersRepository.findAll();
//    }

    @Transactional
    // 주문 조회 id 값 빼내기
    public List<OrderResponseDto> getOrders() {

        List<Orders> orders = ordersRepository.findAll();
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        List<FoodsListResponseDto> foodsListResponseDtos = new ArrayList<>();

        for (Orders orders1 : orders) {
            List<FoodListorder> foodListorders = orders1.getFoods();
            for (FoodListorder foodListorder : foodListorders) {
                FoodsListResponseDto foodsListResponseDto = new FoodsListResponseDto(foodListorder.getName(), foodListorder.getQuantity(), foodListorder.getPrice());
                foodsListResponseDtos.add(foodsListResponseDto);
            }
            String restaurantName = orders1.getRestaurantName();
            int deliveryFee = orders1.getDeliveryFee();
            int totalPrice = orders1.getTotalPrice();

            orderResponseDtos.add(new OrderResponseDto(restaurantName, foodsListResponseDtos, deliveryFee, totalPrice));


        }
        return orderResponseDtos;

    }
}
