package com.Airtickets.Inaplane.controller;
import com.Airtickets.Inaplane.facade.TicketsFacade;
import com.Airtickets.Inaplane.facade.interfaces.ITicketsFacade;
import com.Airtickets.Inaplane.persistence.DTO.CityTicketDTO;
import com.Airtickets.Inaplane.persistence.DTO.TicketsDTO;
import com.Airtickets.Inaplane.persistence.entity.Tickets.*;
import com.Airtickets.Inaplane.service.FromService;
import com.Airtickets.Inaplane.service.PlaneService;
import com.Airtickets.Inaplane.service.TicketsService;
import com.Airtickets.Inaplane.service.ToService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/catalog")
class BffController {
    Logger logger = LoggerFactory.getLogger(BffController.class);

    private final ITicketsFacade ticketsFacade;

    public BffController( ITicketsFacade iTicketsFacade) {
        this.ticketsFacade = iTicketsFacade;
    }

    @GetMapping("/tickets/{id}")
    public String getAllTickets (@ModelAttribute("model") TicketsDTO model){
         //var ticket = ticketsFacade.getAllTickets();
        var item = ticketsFacade.getAllTickets();
        var ticket =  item.get(model.getId().intValue());
        model.timeFrom = ticket.timeFrom;
        model.cityFrom = ticket.cityFrom;
        model.dateFrom = ticket.dateFrom;
        model.countryFrom = ticket.countryFrom;
        model.city_to = ticket.city_to;
        model.currency = ticket.currency;
        model.price = ticket.price;
        model.time_in = ticket.time_in;
        model.id = ticket.id;
        return "/catalog/tickets";
    }

    @PostMapping("/tickets/{id}")
    public String getFilterTickets (@ModelAttribute("model") TicketsDTO model){
         var ticket = ticketsFacade.getAllTickets();
        return "/catalog/tickets";
    }

}