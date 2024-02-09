package com.kitri.mytodo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ERController implements ErrorController {
    @RequestMapping(value = "/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null){
            int statusCode = Integer.valueOf(status.toString());
            //404 405 500 에러 전부 이곳으로
            if(statusCode == HttpStatus.NOT_FOUND.value() || statusCode == 405 || statusCode == 500){
                return "/project/errors/error";
            }
        }
        return "error";
    }
}
