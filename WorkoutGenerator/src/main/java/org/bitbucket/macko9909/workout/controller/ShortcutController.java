package org.bitbucket.macko9909.workout.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ShortcutController {

    @GetMapping("/home")
    public String home(HttpServletResponse response){
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "home";
    }

    @GetMapping("/about_me")
    public String aboutMe(HttpServletResponse response){
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "about_me";
    }

    @GetMapping("/my_experience")
    public String myExperience(HttpServletResponse response){
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "my_experience";
    }

    @GetMapping("/contact")
    public String contact(HttpServletResponse response){
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "contact";
    }
}
