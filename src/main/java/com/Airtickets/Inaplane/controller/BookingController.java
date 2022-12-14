package com.Airtickets.Inaplane.controller;

import com.Airtickets.Inaplane.facade.interfaces.ITicketsFacade;
import com.Airtickets.Inaplane.facade.interfaces.IUserFacade;
import com.Airtickets.Inaplane.persistence.DTO.*;
import com.Airtickets.Inaplane.persistence.types.AgeTicket;
import com.Airtickets.Inaplane.persistence.types.TicketTypeClass;
import com.Airtickets.Inaplane.util.SecurityUtil;
import com.Airtickets.Inaplane.util.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {
    private final ITicketsFacade ticketsFacade;
    private final UserValidator userValidator;
    private  final IUserFacade userFacade;

    public BookingController(ITicketsFacade iTicketsFacade, UserValidator userValidator, IUserFacade userFacade) {
        this.ticketsFacade = iTicketsFacade;
        this.userValidator = userValidator;
        this.userFacade = userFacade;
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
            model.time = ticket.getTime();
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
    @GetMapping("/ticket")
    public String bookTicket(@RequestParam(value = "id_ticket") Long id, @RequestParam(value = "date_ticket") String date,
                             @RequestParam(value = "time_ticket") String time,  Model model){
        try{

            //LocalDate dateTicket = LocalDate.parse(date);
            var ticket = ticketsFacade.getTicketById(id);
            var name = SecurityUtil.getUsername();
            if (name == null){
                return "redirect:/auth/login";
            }
            var user = userFacade.loadUserByUsername(name);
            UserBookingTicketDTO bookingTicket = new UserBookingTicketDTO(ticket, user);
            bookingTicket.timeBookingTicket = time;
            bookingTicket.dateBookingTicket = date;
            model.addAttribute("userBooking", bookingTicket);
        }
        catch (Exception e){
            System.out.println(e);
            return "redirect:/auth/login";
        }

        return "catalog/booking";
    }

    @PostMapping("/ticket")
    public String creatingUserTicket(@RequestParam(value = "id_ticket") Long id, @RequestParam(value = "date_ticket") String date,
                                     @RequestParam(value = "time_ticket") String time,  @RequestParam(value = "age_ticket") String age,
                                     @RequestParam(value = "type_ticket") String type){
        TicketsDTO ticket = ticketsFacade.getTicketById(id);
        var name = SecurityUtil.getUsername();
        if (name == null){
            return "redirect:/auth/login";
        }
        var user = userFacade.loadUserByUsername(name);
        UserBookingTicketDTO bookingTicket = new UserBookingTicketDTO(ticket, user);
        bookingTicket.timeBookingTicket = time;
        bookingTicket.dateBookingTicket = date;

        bookingTicket.userDTO.ageTicket = AgeTicket.valueOf(age);
        bookingTicket.userDTO.typeClass = TicketTypeClass.valueOf(type);
        int place = userFacade.setPlaceNumber(bookingTicket);

        if(place <= 0){
            return "redirect:/error";
        }

        if(TicketTypeClass.valueOf(type).equals(TicketTypeClass.BUSINESS_CLASS)){
            bookingTicket.setPrice(ticket.getPrice() + (ticket.getPrice() * 30)/100);
        }

        else if(TicketTypeClass.valueOf(type).equals(TicketTypeClass.FIRST_CLASS)){
            bookingTicket.setPrice(ticket.getPrice() + (ticket.getPrice() * 75)/100);
        }

        if(AgeTicket.valueOf(age).equals(AgeTicket.CHILD)){
            bookingTicket.setPrice(bookingTicket.getPrice() - (bookingTicket.getPrice() * 25)/100);
        }

        bookingTicket.userDTO.placeNumber = place;
        userFacade.addTicketUser(bookingTicket);
        return "redirect:/booking/profile";
    }
    @GetMapping("/profile")
    public String profilePage(@ModelAttribute("profile") ProfileList model){

        var name = SecurityUtil.getUsername();
        if (name == null){
            return "redirect:/auth/login";
        }

        if(SecurityUtil.hasRole("ROLE_ADMIN")){
            return "redirect:/catalog/add_ticket";
        }

        var user = userFacade.getUserTickets(name);
        model.setTicket(user);
        return "profile";
    }
    @GetMapping("/remove_ticket")
    public String removeBookingTicketPage(@ModelAttribute("profile") ProfileList model){
        var name = SecurityUtil.getUsername();
        if (name == null){
            return "redirect:/auth/login";
        }
        var user = userFacade.getUserTickets(name);
        model.setTicket(user);
        return "/catalog/remove_booking_ticket";
    }
     @PostMapping("/remove_ticket")
        public String removeTicket(@RequestParam(value = "ticket") Long id){
            userFacade.deleteUserTicket(id);
            return "redirect:/booking/profile";
        }

}
