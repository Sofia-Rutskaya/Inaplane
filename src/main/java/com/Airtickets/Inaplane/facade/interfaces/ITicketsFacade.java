package com.Airtickets.Inaplane.facade.interfaces;

import com.Airtickets.Inaplane.persistence.DTO.*;
import com.Airtickets.Inaplane.persistence.entity.Tickets.TimeTicket;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ITicketsFacade extends BaseFacade{
    List<TicketsDTO> getAllTickets ();
    List<CityFromDTO> getAllCityFrom ();
    List<CityToDTO> getAllCityTo ();
    Long getTicket(String cityFrom, String cityTo, LocalDate datatime);
    TicketsDTO getTicketById(@PathVariable Long id);
    void createTicket(@RequestBody TicketsDTO  ticketDto, @RequestBody PlaneDTO planeDto);
    void deleteTickets(@RequestBody TicketsDTO  ticketDto);
    List<PlaneDTO> getAllPlanes ();
    void createTime(@RequestBody TimeDTO time);
    void deleteTime (@PathVariable Long id);
}
