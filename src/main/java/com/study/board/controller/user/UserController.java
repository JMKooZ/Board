package com.study.board.controller.user;

import com.study.board.domain.common.SearchDto;
import com.study.board.domain.user.UserMapper;
import com.study.board.domain.user.UserRequest;
import com.study.board.domain.user.UserResponse;
import com.study.board.service.user.UserService;
import com.study.board.service.user.UserServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login.do")
    public String openLogin() {
        return "user/login";
    }

    @PostMapping("/users")
    @ResponseBody
    public Long saveUser(@RequestBody final UserRequest params) {
        return userService.saveUser(params);
    }

    @GetMapping("/users/{loginId}")
    @ResponseBody
    public UserResponse findUser(@PathVariable final String loginId) {
        return userService.findById(loginId);
    }

    @PatchMapping("/users/{uno}")
    @ResponseBody
    public Long updateUser(@PathVariable final Long uno, @RequestBody final UserRequest params) {
        return userService.update(params);
    }

    @DeleteMapping("/users/{uno}")
    @ResponseBody
    public Long deleteUser(@PathVariable final Long uno) {
        return userService.deleteByUno(uno);
    }

    @GetMapping("/user-count")
    @ResponseBody
    public int countUser(@RequestParam final String loginId) {
        return userService.countById(loginId);
    }

    @PostMapping("/login")
    @ResponseBody
    public UserResponse loginUser(HttpServletRequest request) {
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");

        UserResponse user = userService.loginUser(loginId, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(30 * 60);
        }
        return user;
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
