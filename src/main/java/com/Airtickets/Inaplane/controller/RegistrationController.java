package com.Airtickets.Inaplane.controller;

import com.Airtickets.Inaplane.facade.interfaces.ITicketsFacade;
import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.persistence.repository.IUserRepository;
import com.Airtickets.Inaplane.persistence.types.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private IUserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(RegisteredUser user, Map<String, Object> model) {
        RegisteredUser userFromDb = userRepository.findByUsername(user.getFullName());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setEnabled(true);
        user.setRoles(Roles.REGISTERED_USER);
        userRepository.save(user);

        return "redirect:/login";
    }
}