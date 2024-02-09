package com.kitri.mytodo.interceptors;

import com.kitri.mytodo.dto.MemberInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LogInter implements HandlerInterceptor {
    //api직접접근 차단
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MemberInfo sessionInfo = (MemberInfo) request.getSession().getAttribute("sessionId");
        if(sessionInfo != null){
            return true;
        }
        response.sendRedirect("http://localhost:8080/mytodo/apiAD.html");
        return false;
    }
}