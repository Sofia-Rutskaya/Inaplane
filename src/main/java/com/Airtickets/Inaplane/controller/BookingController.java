package com.Airtickets.Inaplane.controller;

import com.Airtickets.Inaplane.facade.interfaces.ITicketsFacade;
import com.Airtickets.Inaplane.facade.interfaces.IUserFacade;
import com.Airtickets.Inaplane.persistence.DTO.*;
import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.persistence.types.AgeTicket;
import com.Airtickets.Inaplane.persistence.types.TicketTypeClass;
import com.Airtickets.Inaplane.security.UserDetail;
import com.Airtickets.Inaplane.util.SecurityUtil;
import com.Airtickets.Inaplane.util.UserValidator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.stream.Collectors;

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
