package com.hackathon.Channel.controller;

import com.hackathon.Channel.domain.Member;
import com.hackathon.Channel.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("member")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/memberList")
    public List<Member> getMemberList(){
        return memberService.readMembers();
    }
    @PostMapping("/join")
    public String joinMember(@RequestParam String email, @RequestParam String password, @RequestParam String name){
        Member member = new Member(email, password, name);
        return memberService.join(member);
    }
    @PostMapping("/delete")
    public String deleteMember(@RequestParam String email){
        return memberService.delete(email);
    }
    @PostMapping("/update")
    public String updateMember(@RequestParam String email, @RequestParam String password, @RequestParam String name){
        Member member = new Member(email, password, name);
        return memberService.update(member);
    }

}
