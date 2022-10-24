package com.Airtickets.Inaplane.controller;

import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.service.UserService;
import com.Airtickets.Inaplane.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class RegistrationController {

    private final UserValidator userValidator;
    private final UserService userService;
    @Autowired
    public RegistrationController(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") RegisteredUser user) {
        return "auth/registration";
    }
    @PostMapping("/registration")
    public String createUser(@ModelAttribute("user") @Valid RegisteredUser user, BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors()){
            return "/auth/registration";
        }
        userService.register(user);
        return "redirect:/auth/login";
    }
}