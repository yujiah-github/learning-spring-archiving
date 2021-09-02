package com.example.hello.service;
import com.example.hello.repository.MemberRepository;
import com.example.hello.domain.Member;
import com.example.hello.repository.MemoryMemberRepository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    MemberRepository memberRepository;
    Member member;

    long start = System.currentTimeMillis();

    /**
         * 회원가입
         */
        try {
            validateDuplicateMember(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally{
            long finish = System.currentTimeMillis();
            long timeMS = finish - start;
            System.out.println("join" +timeMS + "ms");

    }

        private Object validateDuplicateMember(Member member) {
            memberRepository.findByName(member.getName())
                    .ifPresent(m ->

                    {
                        throw new IllegalStateException("이미 존재하는 회원입니다.");
                    });

            /**
             * 전체 회원 조회
             */

            public List<Member> findMembers(){
                long start = System.currentTimeMillis();

                try{
                    return memberRepository.findAll();
                } finally {
                    long finish = System.currentTimeMillis();
                    long timeMS = finish - start;
                    System.out.println("findMembers" + timeMS +"MS");
                }
            }


        }
    }
