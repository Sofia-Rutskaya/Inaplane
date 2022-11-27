package com.Airtickets.Inaplane.facade.interfaces;

import com.Airtickets.Inaplane.persistence.DTO.ProfileTicket;
import com.Airtickets.Inaplane.persistence.DTO.UserBookingTicketDTO;
import com.Airtickets.Inaplane.persistence.DTO.UserDTO;
import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;

import java.util.List;

public interface IUserFacade {
    UserDTO loadUserByUsername(String username);
    void register(RegisteredUser user);
    void addTicketUser(UserBookingTicketDTO userBooking);
    int setPlaceNumber(UserBookingTicketDTO userBooking);
    List<ProfileTicket> getUserTickets(String username);
    void deleteUserTicket(Long id);
}
