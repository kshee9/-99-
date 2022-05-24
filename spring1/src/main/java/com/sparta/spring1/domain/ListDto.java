package com.sparta.spring1.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class  ListDto {
    private final String username;
    private final String title;
    private final LocalDateTime modifiedAt;

    public  ListDto(Memo memo){
        this.title =memo.getTitle();
        this.username =memo.getUsername();
        this.modifiedAt =memo.getModifiedAt();

    }
}
