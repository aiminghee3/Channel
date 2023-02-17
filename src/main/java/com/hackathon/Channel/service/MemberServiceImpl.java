package com.hackathon.Channel.service;

import com.hackathon.Channel.domain.Member;
import com.hackathon.Channel.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    @Override
    public String join(String name) {
        return memberRepository.addUser(name);
    }

    /**
     * 회원 삭제
     */
    @Override
    public String delete(String email) {
        return memberRepository.deleteUser(email);
    }
    /**
     * 회원 업데이트
     */
    @Override
    public String update(String name) {
        return memberRepository.updateUser(name);
    }

    /**
     * 회원 리스트 가져오기
     */
    @Override
    public List<Member> readMembers() {
        return memberRepository.readMembers();
    }
}
