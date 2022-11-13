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


            model.setTime(ticket.getTime());
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
        return "/admin/add_ticket";
    }
    @PostMapping(value = "/add_ticket")
    public String addTicket(@ModelAttribute("model") TicketsDTO model, @ModelAttribute("plane") PlaneDTO plane){
        plane.setAllCountPlaces(plane.getBusinessFreePlaces() + plane.getEconomyFreePlaces() + plane.getFirstFreePlaces());
        ticketsFacade.createTicket(model, plane);
        return "redirect:/catalog/add_ticket";
    }
    @GetMapping("/remove_ticket")
    public String deleteTicketPage(@RequestParam(value = "currentPage") int currentPage, @ModelAttribute("model") RemoveTicketList model){

        var tickets = ticketsFacade.getAllTickets();
        var plane= ticketsFacade.getAllPlanes();
        RemoveTicketList modelTickets = new RemoveTicketList();
        modelTickets.setTickets(new ArrayList<>());


        for( int i = 0 ; i< tickets.size(); i++){
            RemoveTicketsDto ticketsDto = new RemoveTicketsDto(tickets.get(i), plane.get(i));
            modelTickets.getTickets().add(ticketsDto);
        }

        Pagination<RemoveTicketsDto> pages = new Pagination();
        pages.setItems(modelTickets.getTickets());
        pages.setCurrentPage(currentPage);
        model.setTickets(new ArrayList<>());
        model.getTickets().addAll(pages.currentItems());

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
        for(int i = 0; i< ticket.getTime().size(); i++){
            model.times.add(new TimeDTO(1l, 1l, ticket.getTime().get(i).getTime(), ticket.getTime().get(i).getDate()));
        }
        return "/admin/time_ticket";
    }

    @GetMapping("/time_ticket/{id}/add")
    public String timeAddPage(@RequestParam(value = "currentPage") int currentPage, @PathVariable Long id, @ModelAttribute("model") TimeDTO model, @ModelAttribute("list") TimeList list){
        var ticket = ticketsFacade.getTicketById(id);
        list.times = new ArrayList<>();

        for(int i = 0; i< ticket.getTime().size(); i++){
            list.times.add(new TimeDTO(ticket.getId(), ticket.getTime().get(i).getId() ,ticket.getTime().get(i).getTime(), ticket.getTime().get(i).getDate()));
        }


        Pagination<TimeDTO> pages = new Pagination();
        pages.setItems(list.times);
        pages.setCurrentPage(currentPage);
        list.setTimes(new ArrayList<>());
        list.getTimes().addAll(pages.currentItems());


        return "/admin/add_time_ticket";
    }

     @PostMapping("/time_ticket/{id}/add")
        public String timeAdd(@PathVariable Long id, @ModelAttribute("model") TimeDTO model, @ModelAttribute("list") TimeList list){
        ticketsFacade.createTime(model);
        return "redirect:/admin/time_ticket/" + model.getTicketId() + "/add?currentPage=0";
    }

    @RequestMapping("/time_ticket/{ticketId}/delete/{id}")
        public String timeDelete(@ModelAttribute("model") TimeDTO model, @ModelAttribute("list") TimeList list){

        ticketsFacade.deleteTime(model.getId());
        return "redirect:/admin/time_ticket/" + model.getTicketId() + "/add?currentPage=0";
    }



}