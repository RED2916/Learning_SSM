package com.tydic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.tydic.interceptor.logInInterceptor;

@Controller
@RequestMapping("/AfterLogIn")
public class AfterLogInController {
    @RequestMapping("/hello")
    public String logInSuccess(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        //传输和获得session是成功的
        System.out.println(session.getId());

        //防止错误，从拦截器直接获取变量
        if (session.isNew()){
            System.out.println("error:/AfterLogIn/hello");
        }

        int userId = (int) session.getAttribute(BeforeLogInController.getUserIdKey());
        model.addAttribute(BeforeLogInController.getUserIdKey(),userId);
        return "hello";
    }

}