package com.kitri.mytodo.controller;
import com.kitri.mytodo.dto.MemberInfo;
import com.kitri.mytodo.mappers.MytodoMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Mytodologin")
public class LoginController {
    @Autowired
    MytodoMapper mytodoMapper;
    //로그인 기본매핑
    @GetMapping
    public String Mytodologin(){
        //jsp리턴시 선두 "/" 불필요
        return "project/login/login";
    }
    //로그인
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password,
                        HttpServletRequest req, Model model) {
        List<MemberInfo> memberInfo = mytodoMapper.memberInfo();

        for (MemberInfo entry : memberInfo) {
            Long memberid = entry.getMemberid();
            String emailChk = entry.getEmail();
            String passwordChk = entry.getPassword();
            String sessionName = entry.getName();
            if (emailChk.equals(email)) {
                if (passwordChk.equals(password)) {
                    //성공하면 todolist 페이지 띄우기
                    HttpSession session = req.getSession();
                    MemberInfo sessionInfo = new MemberInfo(entry.getMemberid(), entry.getEmail(), entry.getName(), entry.getPassword());
                    session.setAttribute("sessionId", sessionInfo);
                    model.addAttribute("memberId",memberid);
                    return "project/mytodo/mytodo";
                }
            }
        }
        //실패하면 로그인페이지로
        return "project/login/loginFail";
    }

    //로그아웃 세션끊기
    @GetMapping("/logout")
    public String deleteSession(HttpServletRequest req){
        //세션을 무효화한다
        req.getSession().invalidate();
        return "project/login/login";
    }
}
