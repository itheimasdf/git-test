package com.itheima.interceptor;

import com.itheima.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor  implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        //从session中取出登录用户
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //判断用户是否已登录
        if(user==null){
            response.sendRedirect(request.getContextPath()+"/user/login");
            return false;
        }
        //已登录
        System.out.println(user);
        return true;
    }
}
