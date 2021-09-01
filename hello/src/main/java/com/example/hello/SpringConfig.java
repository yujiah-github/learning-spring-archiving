package com.example.hello;

import com.example.hello.repository.JdbcMemberRepository;
import com.example.hello.repository.MemberRepository;
import com.example.hello.repository.MemoryMemberRepository;
import com.example.hello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

 public SpringConfig(MemberRepository memberRepository) {
     this.memberRepository = memberRepository;
 }

    @Bean
    public MemberService memberService(){
     return new MemberService(memberRepository);

 }
}
