package com.Airtickets.Inaplane.controller;

import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.persistence.repository.UserRepo.IUserRepository;
import com.Airtickets.Inaplane.persistence.types.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/Reg")
public class RegistrationController {
    @Autowired
    private IUserRepository userRepository;

    @GetMapping("/registration")
    public ModelAndView registration() {
        return  new ModelAndView("forward:/registration");
    }
    @PostMapping("/registration")
    public ModelAndView addUser(RegisteredUser user, Map<String, Object> model) {
        RegisteredUser userFromDb = userRepository.findByUsername(user.getFullName());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return  new ModelAndView("forward:/registration");
        }

        user.setEnabled(true);
        user.setRoles(Roles.REGISTERED_USER);
        userRepository.save(user);

        return  new ModelAndView("forward:/registration");
    }
}