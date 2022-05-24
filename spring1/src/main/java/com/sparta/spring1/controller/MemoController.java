package com.sparta.spring1.controller;

import com.sparta.spring1.domain.*;
import com.sparta.spring1.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;


    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }


    @GetMapping("/api/memos")
    public List<ListDto> getMemos( ) {
        List<Memo> memo2= memoRepository.findAllByOrderByModifiedAtDesc();
        ArrayList<ListDto> list = new ArrayList<>();

        for (Memo memo : memo2) {
            ListDto titlist = new ListDto(memo);
            list.add(titlist);
        }

        return list;
    }


    @GetMapping("/api/memos/{id}")
    public Memo getMemos(@PathVariable Long id) {
        return memoRepository.findById(id).get();
    }

    @DeleteMapping("/api/memos/{id}")
    public String deleteMemo(@PathVariable Long id, @RequestBody PasswordDto passwordDto) {
        Optional<Memo> memo  =memoRepository.findById(id);
        //여기 조건문
        if(memo.get().getPassword().equals(passwordDto.getPassword())){
            memoRepository.deleteById(id);
            return "삭제";
        }
        else {
            return "비밀번호가 일치하지 않습니다.";
        }

    }

    @PutMapping("/api/memos/{id}")
    public String updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto, @RequestBody PasswordDto passwordDto) {
        Optional<Memo> memo  =memoRepository.findById(id);
        // 여기 조건문
        if (memo.get().getPassword().equals(passwordDto.getPassword()))
        {
        memoService.update(id, requestDto);
            return "수정";
        }
        else{
            return "비밀번호가 일치하지 않습니다.";
        }
    }

}
