package com.tydic.interceptor;

import com.mysql.cj.util.StringUtils;
import com.tydic.mapper.UserInfoMapper;
import com.tydic.mapper.UserInfoMapperImpl;
import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@SessionAttributes(value = {"userId"})
public class logInInterceptor implements HandlerInterceptor {
    @Getter
    private static String userIdKey = "userId";
    @Getter
    private int userId;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Log In 拦截器：前");
        String userId_string = request.getParameter("userId");
        String password = request.getParameter("password");

        if(userId_string != null && password != null && !userId_string.isEmpty() && !password.isEmpty()){
            //中文乱码-->配置spring自带的乱码处理器后已解决
            System.out.println(userId_string);

            //判断能否转为数字，防止valueOf报错
            if (!StringUtils.isStrictlyNumeric(userId_string)){
                response.sendRedirect("/");
                return false;
            }
            userId = Integer.valueOf(userId_string);
            System.out.println(userId);
        }else{
//            System.out.println("空输入");
            response.sendRedirect("/");
            return false;
        }
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserInfoMapperImpl userinfomapperimpl = context.getBean("userInfoMapper", UserInfoMapperImpl.class);
        if(userinfomapperimpl.getSingInCheck(userId,password)==0){
            System.out.println("登录成功");
            HttpSession session = request.getSession(true);
            System.out.println(session.getId());
            //初始化的时候就存在会话？
//            if (session.isNew()){
//                session.setAttribute(userIdKey,userId);
//            }
            System.out.println(userId);
            session.setAttribute(userIdKey,userId);//失败
            return true;
        }else {
            System.out.println("登录失败");
            response.sendRedirect("/");
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Log In 拦截器：后");
    }

}
