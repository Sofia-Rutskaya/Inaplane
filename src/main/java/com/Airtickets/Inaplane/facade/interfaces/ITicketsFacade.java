package com.Airtickets.Inaplane.facade.interfaces;

import com.Airtickets.Inaplane.persistence.DTO.TicketsDTO;

import java.util.List;

public interface ITicketsFacade extends BaseFacade{
    List<TicketsDTO> getAllTickets ();
}
