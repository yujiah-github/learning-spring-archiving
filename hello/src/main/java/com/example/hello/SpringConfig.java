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

    private final DataSource dataSource;
    private final EntityManager em;

@Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService(){ return new MemberService(memberRepository());}

    @Bean
    public MemberRepository memberRepository()
    {
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(em);
    }
}
