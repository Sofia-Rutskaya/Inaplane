package com.Airtickets.Inaplane.service.interfaces;

import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;

import java.util.Optional;

public interface IUserService {

    Optional<RegisteredUser> loadUserByUsername(String username);
    void register(RegisteredUser user);
}
