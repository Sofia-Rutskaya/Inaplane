package com.Airtickets.Inaplane.controller;
import com.Airtickets.Inaplane.facade.interfaces.ITicketsFacade;
import com.Airtickets.Inaplane.persistence.DTO.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/catalog")
class TicketsController {
    Logger logger = LoggerFactory.getLogger(TicketsController.class);

    private final ITicketsFacade ticketsFacade;

    public TicketsController(ITicketsFacade iTicketsFacade) {
        this.ticketsFacade = iTicketsFacade;
    }

    @GetMapping("/tickets")
    public String getAllTickets ( @RequestParam(value = "id_ticket") Long id, @RequestParam(value = "date_ticket") String date,
                                  @ModelAttribute("model") TicketsDTO model){
         //var ticket = ticketsFacade.getAllTickets();
        try{
            //LocalDate dateTicket = LocalDate.parse(date);
            var ticket = ticketsFacade.getTicketById(id);
            for( int i = 0; i < ticket.dateFrom.size(); i++){
                if(!ticket.dateFrom.get(i).equals(date)){
                    ticket.dateFrom.remove(i);
                    ticket.timeFrom.remove(i);
                }
            }


            model.timeFrom = ticket.timeFrom;
            model.dateBookingTicket = date;
            model.cityFrom = ticket.cityFrom;
            model.countryFrom = ticket.countryFrom;
            model.city_to = ticket.city_to;
            model.currency = ticket.currency;
            model.price = ticket.price;
            model.time_in = ticket.time_in;
            model.id = ticket.id;
        }
        catch (Exception e){
            System.out.println(e);
        }

        return "/catalog/tickets";
    }

    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public String getFilterTickets (@RequestParam(value = "id_ticket") Long id, @RequestParam(value = "date_ticket") String date,
                                    @RequestParam(value = "time_ticket") String time){
         //var ticket = ticketsFacade.getAllTickets();
        return "redirect:/booking/ticket?id_ticket=" + id +"&date_ticket=" + date +"&time_ticket=" + time;
    }
    @RequestMapping(value = "/add_ticket", method = RequestMethod.GET)
    public String addTicketPage(@ModelAttribute("model") TicketsDTO model, @ModelAttribute("plane") PlaneDTO plane){
        return "admin/add_ticket";
    }
    @PostMapping(value = "/add_ticket")
    public String addTicket(@ModelAttribute("model") TicketsDTO model, @ModelAttribute("plane") PlaneDTO plane){
        ticketsFacade.createTicket(model, plane);
        return "redirect:/catalog/add_ticket";
    }
    @GetMapping("/remove_ticket")
    public String deleteTicketPage(@ModelAttribute("model") RemoveTicketList model){

        var tickets = ticketsFacade.getAllTickets();
        var plane= ticketsFacade.getAllPlanes();
        model.tickets = new ArrayList<>();
        for( int i = 0 ; i< tickets.size(); i++){
            RemoveTicketsDto ticketsDto = new RemoveTicketsDto(tickets.get(i), plane.get(i));
            model.tickets.add(ticketsDto);
        }
        return "/admin/remove_ticket";
    }
     @PostMapping("/remove_ticket/{id}")
        public String deleteTicket(@PathVariable Long id, @ModelAttribute("model") RemoveTicketList model){
         var ticket = ticketsFacade.getTicketById(id);
        ticketsFacade.deleteTickets(ticket);

        return "/admin/remove_ticket";
        }

     @GetMapping("/time_ticket/{id}")
     public String timeTicketPage(@PathVariable Long id, @ModelAttribute("model") TimeList model){
        var ticket = ticketsFacade.getTicketById(id);
        model.times = new ArrayList<>();
        for(int i = 0; i< ticket.timeFrom.size(); i++){
            model.times.add(new TimeDTO(ticket.timeFrom.get(i), ticket.dateFrom.get(i)));
        }
        return "/admin/time_ticket";
    }


}