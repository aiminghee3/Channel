package com.hackathon.Channel.service;

import com.hackathon.Channel.domain.Member;

import java.util.List;

public interface MemberService {

    public String join(String name);
    public String delete(String name);
    public String update(String name);
    public List<Member> readMembers();

}
