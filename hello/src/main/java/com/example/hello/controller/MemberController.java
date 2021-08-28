package com.example.hello.controller;

import com.example.hello.domain.Member;
import com.example.hello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    private final MemberService memberService;
    }
