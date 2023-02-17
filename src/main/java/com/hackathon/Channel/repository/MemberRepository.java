package com.hackathon.Channel.repository;

import com.hackathon.Channel.domain.Member;

import java.util.List;

public interface MemberRepository {

    public String addUser(Member member);
    public String deleteUser(String email);
    public String updateUser(Member member);
    public List<Member> readMembers();
}
