package com.hackathon.Channel.service;

import com.hackathon.Channel.domain.Member;

import java.util.List;

public interface MemberService {

    public String join(Member member);
    public String delete(String email);
    public String update(Member member);
    public List<Member> readMembers();

}
