package com.sparta.myrest.controller;


import com.sparta.myrest.dto.OrderRequestDto;
import com.sparta.myrest.dto.OrderResponseDto;
import com.sparta.myrest.model.Orders;
import com.sparta.myrest.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private OrderService orderService;


    @Autowired
    public OrderController(OrderService orderService){
        this.orderService =orderService;
    }

    //주문 등록록
    @PostMapping("/order/request")
    public OrderResponseDto addOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.addOrder(orderRequestDto);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrders(){
        List<OrderResponseDto> orders = orderService.getOrders();
        return  orders;
    }
}
