package com.kitri.mytodo.controller;

import com.kitri.mytodo.dto.MemberInfo;
import com.kitri.mytodo.mappers.MytodoMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/memberadd")
public class MemberController {
    @Autowired
    MytodoMapper mytodoMapper;
    //회원가입 기본 매핑
    @GetMapping
    public String memberAdd(){
        ///jsp리턴시 선두 "/" 불필요
        return "project/member/memberAdd";
    }
    //회원가입
    @PostMapping
    public String readForm(@Valid MemberInfo form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "project/member/memberAdd";
        }
        //패스워드 불일치
        if(!form.getPassword().equals(form.getPasswordChk())){
            return "project/membermemberPwFail";
        }
        //멤버 정보 가져오기
        List<MemberInfo> members = mytodoMapper.memberInfo();
        //멤버 정보에서 순회하며 이메일 중복 없는가 확인
        for(MemberInfo entry : members){
            String email = entry.getEmail();
            if(email.equals(form.getEmail())){
                return "project/member/memberEmailFail";
            }
        }
        //문제 없는 경우 저장
        mytodoMapper.memberSave(form);
        //성공시 연결될 페이지
        return "project/member/memberOk";
    }
}
