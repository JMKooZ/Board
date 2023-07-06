package com.study.board.controller.user;

import com.study.board.domain.user.UserResponse;
import com.study.board.service.user.UserService;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/signUp")
    public String saveUser(){
        return "user/signUp";
    }

    @PostMapping("/user/signUp")
    public String saveUser(final UserResponse user, HttpSession session){
        System.out.println("user.getEmail() = " + user.getEmail());
        userService.saveUser(user);
        UserResponse byUno = userService.findByUno(2L);
        session.setAttribute("user",byUno);
        return "redirect:/post/list.do";
    }

    @GetMapping("/user/logout")
    @ResponseBody
    public String logoutUser(HttpSession session){
        session.removeAttribute("user");
        return "success";
    }
}
