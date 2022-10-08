package com.Airtickets.Inaplane.persistence.DTO;

import com.Airtickets.Inaplane.persistence.entity.Tickets.Tickets;
import com.Airtickets.Inaplane.persistence.types.Currency;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;

@Getter
@Setter
public class UserBookingTicketDTO extends TicketsDTO{
    public UserDTO userDTO;
    public UserBookingTicketDTO(Tickets tickets, UserDTO userDTO) {
        super(tickets);
        this.userDTO = userDTO;
    }
}
