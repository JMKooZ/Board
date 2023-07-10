package com.study.board.interceptor;

import com.study.board.domain.user.UserResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserResponse user = (UserResponse) session.getAttribute("user");

        if (user == null || user.getDeleteYn()){
            response.sendRedirect("/login.do");
            return false;
        }
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }
}
