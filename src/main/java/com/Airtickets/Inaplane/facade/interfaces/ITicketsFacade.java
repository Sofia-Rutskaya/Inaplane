package com.Airtickets.Inaplane.facade.interfaces;

import com.Airtickets.Inaplane.persistence.DTO.CityFromDTO;
import com.Airtickets.Inaplane.persistence.DTO.CityToDTO;
import com.Airtickets.Inaplane.persistence.DTO.TicketsDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ITicketsFacade extends BaseFacade{
    List<TicketsDTO> getAllTickets ();
    List<CityFromDTO> getAllCityFrom ();
    List<CityToDTO> getAllCityTo ();
    Long getTicket(String cityFrom, String cityTo, LocalDate datatime);
}
