package com.core_2022.member;

public class RateDiscountPolicy implements DiscountPolicy{

    private final int rateDiscountAmount = 10;

    @Override
    public int discount(int price, Member member) {
        if(member.getGrade() == Grade.VIP){
            return price * rateDiscountAmount / 100;

        }
        else{
            return 0;

        }
    }
}
