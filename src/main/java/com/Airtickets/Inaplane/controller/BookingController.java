package com.Airtickets.Inaplane.controller;

import com.Airtickets.Inaplane.facade.interfaces.ITicketsFacade;
import com.Airtickets.Inaplane.facade.interfaces.IUserFacade;
import com.Airtickets.Inaplane.persistence.DTO.UserBookingTicketDTO;
import com.Airtickets.Inaplane.persistence.DTO.UserDTO;
import com.Airtickets.Inaplane.security.UserDetail;
import com.Airtickets.Inaplane.util.UserValidator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                             @RequestParam(value = "time_ticket") String time,  @ModelAttribute("model") UserBookingTicketDTO model,
                             @AuthenticationPrincipal UserDetail userDetail, @CurrentSecurityContext SecurityContext context){
        try{

            //LocalDate dateTicket = LocalDate.parse(date);
            var ticket = ticketsFacade.getTicketById(id);

            model.timeBookingTicket = time;
            model.dateBookingTicket = date;
            model.cityFrom = ticket.cityFrom;
            model.countryFrom = ticket.countryFrom;
            model.city_to = ticket.city_to;
            model.country_to = ticket.country_to;
            model.currency = ticket.currency;
            model.price = ticket.price;
            model.time_in = ticket.time_in;
            model.id = ticket.id;

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            UserDetail detail = (UserDetail) authentication.getPrincipal();
            var ite = detail.getUsername();

            if (ite == null){
                return "redirect:/auth/login";
            }
            var name = SecurityContextHolder.getContext().getAuthentication();
            var user = userFacade.loadUserByUsername(name.getName());
            model.userDTO = new UserDTO(user.userId, user.fullName,
                    user.placeNumber, user.email, user.typeClass,
                    user.finalPrice, user.role);

        }
        catch (Exception e){
            System.out.println(e);
        }

        return "catalog/booking";
    }

}
