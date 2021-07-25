package hello.core;

import hello.core.Member.*;
import hello.core.discount.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //스프링 컨테이너에 저장하는 것
@Bean
    public MemberService memberService(){
        return new MemberServiceImpl((memberRepository()));

    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }
    @Bean
    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}

