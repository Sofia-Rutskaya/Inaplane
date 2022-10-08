package com.Airtickets.Inaplane.facade;

import com.Airtickets.Inaplane.facade.interfaces.IUserFacade;
import com.Airtickets.Inaplane.persistence.DTO.UserDTO;
import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserFacade implements IUserFacade {
    private final IUserService userService;

    public UserFacade(IUserService userService) {
        this.userService = userService;
    }

    public void register(RegisteredUser user){
        userService.register(user);
    }

    public UserDTO loadUserByUsername(String username){
        var user = userService.loadUserByUsername(username);

        UserDTO userDTO = new UserDTO(user.get());
        return userDTO;
    }
}
