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
    public String join(Member member) {
        memberRepository.addUser(member);
        return null;
    }

    /**
     * 회원 삭제
     */
    @Override
    public String delete(String email) {
        memberRepository.deleteUser(email);
        return null;
    }
    /**
     * 회원 업데이트
     */
    @Override
    public String update(Member member) {
        memberRepository.updateUser(member);
        return null;
    }

    /**
     * 회원 리스트 가져오기
     */
    @Override
    public List<Member> readMembers() {
        return memberRepository.readMembers();
    }
}
