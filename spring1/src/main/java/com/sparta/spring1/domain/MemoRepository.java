package com.sparta.spring1.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();
    // 쿼리를 이용한 db에서 비교법 밑에 문장을 써서  컨트롤러에 가서 값을 비교한다.

    //Optional<Memo> findByIdAndPassword(Long id, String password);
}

