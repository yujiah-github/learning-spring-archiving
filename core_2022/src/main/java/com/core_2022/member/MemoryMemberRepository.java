package com.core_2022.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    private static HashMap<Long, Member> store = new HashMap<>(); // -> 왜 long이랑 member지?

    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //member 아이디를 읽어서 member에 저장
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
