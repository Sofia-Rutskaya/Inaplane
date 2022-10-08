package com.Airtickets.Inaplane.facade.interfaces;

import com.Airtickets.Inaplane.persistence.DTO.UserDTO;
import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;

public interface IUserFacade {
    UserDTO loadUserByUsername(String username);
    void register(RegisteredUser user);
}
