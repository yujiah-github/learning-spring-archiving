package com.example.hello.repository;

import com.example.hello.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    //자바 8기능 > 없으면 널로 반환
    List<Member> findAll();

    void clearStore();
}
