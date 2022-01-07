package com.core_2022.member;

public interface MemberService {

    //회원 가입, 회원 조회
    void join(Member member);
    Member findMember(Long memberId);
}
