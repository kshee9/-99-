package com.sparta.spring1.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemoRequestDto {
   private final String username;
   private final String title;
   private final String password;
   private final String content;
}
// 콘텐트랑 패스워드 final 넣었다