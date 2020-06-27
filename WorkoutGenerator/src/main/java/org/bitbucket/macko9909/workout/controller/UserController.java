package org.bitbucket.macko9909.workout.controller;

import org.bitbucket.macko9909.workout.managers.UserManager;
import org.bitbucket.macko9909.workout.model.User;
import org.bitbucket.macko9909.workout.security.CryptWithMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private CryptWithMD5 cryptWithMD5;

    @GetMapping("/new_user")
    public String getAddUser(HttpServletResponse response, User user) {
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "new_user";
    }

    @PostMapping("/add_user")
    public String saveUser(@Valid User user, BindingResult result) {
        User existing = userManager.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {

            return "new_user";
        }
        String password = user.getPassword();
        user.setPassword(cryptWithMD5.cryptWithMD5(password));
        userManager.saveUser(user);
        return "saved";
    }
}
