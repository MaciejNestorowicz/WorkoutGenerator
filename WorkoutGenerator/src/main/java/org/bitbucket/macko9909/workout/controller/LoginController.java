package org.bitbucket.macko9909.workout.controller;

import org.bitbucket.macko9909.workout.managers.UserManager;
import org.bitbucket.macko9909.workout.model.*;
import org.bitbucket.macko9909.workout.security.CryptWithMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private CryptWithMD5 cryptWithMD5;

    @GetMapping("/login")
    public String login(HttpServletResponse response, UserDTO userDTO){
            Cookie cookie = new Cookie("user", null);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            return "login";
    }

    @PostMapping("/loginUser")
    public String loginUser(UserDTO userDTO, HttpServletResponse response, BindingResult result){
        if (userManager.findUserByEmailAndPassword(userDTO.getEmail(), cryptWithMD5.cryptWithMD5(userDTO.getPassword())) == null) {
            result.rejectValue("email", null, "User not found");
        }
        if (result.hasErrors()) {

            return "login";
        }
        User user = userManager.findUserByEmailAndPassword(userDTO.getEmail(), cryptWithMD5.cryptWithMD5(userDTO.getPassword()));
        Cookie cookie = new Cookie("user", user.getEmail());
        response.addCookie(cookie);

        return "redirect:user_page";
    }
}
