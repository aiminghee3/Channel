package com.hackathon.Channel;


import com.hackathon.Channel.repository.MemberRepository;
import com.hackathon.Channel.repository.MemberRepositoryImpl;
import com.hackathon.Channel.service.MemberService;
import com.hackathon.Channel.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class Config {

    @PersistenceContext    // EntityManagerFactory가 DI 할 수 있도록 어노테이션 설정
    private EntityManager em;

    @Bean
    public MemberRepository memberRepository(){
        return new MemberRepositoryImpl(em);
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(new MemberRepositoryImpl(em));
    }
}
