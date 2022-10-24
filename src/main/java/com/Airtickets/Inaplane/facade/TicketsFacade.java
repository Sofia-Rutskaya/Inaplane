package com.Airtickets.Inaplane.facade;

import com.Airtickets.Inaplane.persistence.DTO.PlaneDTO;
import com.Airtickets.Inaplane.persistence.DTO.TicketsDTO;
import com.Airtickets.Inaplane.persistence.entity.Tickets.Airport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public interface TicketsFacade extends BaseFacade {

    List<TicketsDTO> getAllTickets ();
    //List<Airport> getAllCityFrom ();
   // List<CityToDTO> getAllCityTo ();
    Long getTicket(String cityFrom, String cityTo, LocalDate datatime);
    TicketsDTO getTicketById(@PathVariable Long id);
    void createTicket(@RequestBody TicketsDTO  ticketDto, @RequestBody PlaneDTO planeDto);
    void deleteTickets(@RequestBody TicketsDTO  ticketDto);
    List<PlaneDTO> getAllPlanes ();

}
