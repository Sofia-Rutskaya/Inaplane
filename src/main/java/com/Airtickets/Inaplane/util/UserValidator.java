package com.Airtickets.Inaplane.util;


import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return RegisteredUser.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisteredUser user = (RegisteredUser) target;

        if(userService.loadUserByUsername(user.getFullName()).isEmpty()){
            return;
        }

        errors.rejectValue("fullName", "","User already exist!");
    }
}
