package com.example.hello.service;
import com.example.hello.repository.MemberRepository;
import com.example.hello.domain.Member;
import com.example.hello.repository.MemoryMemberRepository;


import java.util.List;
import java.util.Optional;
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
         * 회원가입
         */
        public Long join(Member member) {
            validateDuplicateMember(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();
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
                return memberRepository.findAll();
            }

            public Optional<Member> findOne(Long memberid){
                return memberRepository.findById(Long memberid);
            }

        }
    }
