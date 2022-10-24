package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.Tickets.UsersTicket;
import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<RegisteredUser> loadUserByUsername(String username);
    void register(RegisteredUser user);
    void addUserTicket(UsersTicket ticket);
    void updateUser(RegisteredUser user);
    List<UsersTicket> getUserTickets();
    void deleteUserTicket(Long id);
}
