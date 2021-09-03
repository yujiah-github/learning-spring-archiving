package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price); //멤버값이랑 가격 넘김
}
