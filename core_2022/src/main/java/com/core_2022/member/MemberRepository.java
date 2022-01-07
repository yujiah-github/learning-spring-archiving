package com.core_2022.member;

public interface MemberRepository {
    //회원 저장, 아이디로 회원 찾기
    void save(Member member); // Member를 저장해야하니까
    Member findById(Long memberId);
}
