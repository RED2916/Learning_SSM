package com.tydic.controller;

import com.tydic.service.UserInfoServiceImpl;
import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BeforeLogInController {
    @Getter
    private static String userIdKey = "userId";
    @RequestMapping("/logIn")
    public String logIn(@RequestParam("userId") int userId, @RequestParam("password") String password, HttpServletRequest request){
        if( password != null && !password.isEmpty()){
            //中文乱码-->配置spring自带的乱码处理器后已解决
            System.out.println(userId);
            System.out.println(password);
        }else{
            return "redirect:/";
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInfoServiceImpl userInfoService = context.getBean("userInfoServiceImpl", UserInfoServiceImpl.class);
        if(userInfoService.getSingInCheck(userId,password)==0) {
            System.out.println("登录成功");
            HttpSession session = request.getSession(true);
            session.setAttribute(userIdKey, userId);
            return "redirect:/AfterLogIn/books/showAllBooks";
        }else{
            System.out.println("登录失败");
            return "redirect:/";
        }
    }
}
