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
    public String joinMember(@RequestParam String name){
        return memberService.join(name);
    }
    @PostMapping("/delete")
    public String deleteMember(@RequestParam String name){
        return memberService.delete(name);
    }
    @PostMapping("/update")
    public String updateMember(@RequestParam String name){
        return memberService.update(name);
    }

}
