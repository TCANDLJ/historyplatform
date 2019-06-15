package com._520it.config;

import com._520it.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 超哥 on 2019/4/23.
 */
@Component
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User admin= (User) request.getSession().getAttribute("admin");
        if(admin==null){
            response.sendRedirect("/login");
        }
        return true;
    }
}
