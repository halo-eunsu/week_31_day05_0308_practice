package com.nhnacademy.security.controller;


import com.nhnacademy.security.entity.Member;
import com.nhnacademy.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.ui.Model;

@RequiredArgsConstructor
@Controller
public class HomeController {

    public final MemberService memberService;

    @GetMapping("/")
    public String home(Model model, @SessionAttribute(name = "loginId", required = false) String loginId) {
        Member member = memberService.getMember(loginId);
        model.addAttribute("loginName", member.getName());
        return "home";

    }

}
