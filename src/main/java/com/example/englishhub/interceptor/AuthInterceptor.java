package com.example.englishhub.interceptor;

import com.example.englishhub.utils.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        System.out.println("进入拦截器");
        if (req.getMethod().equals("OPTIONS")) {
            resp.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        resp.setCharacterEncoding("utf-8");
        String token = req.getHeader("token");
        String id = JwtUtil.validateToken(token);
        if (id == "") {
            System.out.println("认证失败, token过期");
            resp.sendError(414);
            return false;
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        System.out.println("认证成功：用户 "+id+" 访问资源");
        return true;
    }
}