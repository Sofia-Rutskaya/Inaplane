package com.Airtickets.Inaplane.controller;
import com.Airtickets.Inaplane.facade.TicketsFacade;
import com.Airtickets.Inaplane.facade.interfaces.ITicketsFacade;
import com.Airtickets.Inaplane.persistence.DTO.TicketsDTO;
import com.Airtickets.Inaplane.persistence.entity.Tickets.*;
import com.Airtickets.Inaplane.service.FromService;
import com.Airtickets.Inaplane.service.PlaneService;
import com.Airtickets.Inaplane.service.TicketsService;
import com.Airtickets.Inaplane.service.ToService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Catalog")
class BffController {
    Logger logger = LoggerFactory.getLogger(BffController.class);

    private final ITicketsFacade ticketsFacade;

    public BffController( ITicketsFacade iTicketsFacade) {
        this.ticketsFacade = iTicketsFacade;
    }

    @GetMapping("/Tickets")
    public List<TicketsDTO> getAllTickets (){
         var ticket = ticketsFacade.getAllTickets();
        return ticket;
    }

}