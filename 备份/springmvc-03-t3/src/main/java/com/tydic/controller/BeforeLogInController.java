package com.tydic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BeforeLogInController {
    @RequestMapping("/logIn")
    public void logIn(int userId,String password){
        
    }
}
