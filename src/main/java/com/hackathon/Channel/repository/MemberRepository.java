package com.hackathon.Channel.repository;

import com.hackathon.Channel.domain.Member;

import java.util.List;

public interface MemberRepository {

    public String addUser(String name);
    public String deleteUser(String name);
    public String updateUser(String name);
    public List<Member> readMembers();
}
