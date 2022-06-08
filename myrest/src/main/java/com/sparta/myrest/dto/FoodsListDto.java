package com.sparta.myrest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;

@Getter
@NoArgsConstructor
public class FoodsListDto {
    //API 명세서에 ID 값과 수량을 정해주기에
    // 요청값들을 받아오는 멤버변수 설정
    private Long id;

    private int quantity;


}
