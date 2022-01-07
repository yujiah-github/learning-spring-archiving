package com.core_2022.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) { //회원 가입
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) { //회원 조회 -> 메서드 이름 같으면 혼동이 올까봐 다르게 한 듯?
        return memberRepository.findById(memberId);
    }
}
