package com.Airtickets.Inaplane.controller;

import com.Airtickets.Inaplane.facade.TicketsFacade;
import com.Airtickets.Inaplane.persistence.DTO.CityTicketDTO;
import com.Airtickets.Inaplane.security.UserDetail;
import com.Airtickets.Inaplane.util.SecurityUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private final TicketsFacade ticketsFacade;

    public HomeController( TicketsFacade ticketsFacade) {
        this.ticketsFacade = ticketsFacade;
    }

    @GetMapping("/home")
    public String homePage(@ModelAttribute("model") CityTicketDTO model){
        List<String> cityFromList = new ArrayList<>();
        List<String> cityToList = new ArrayList<>();

        var ticket = ticketsFacade.getAllTickets();

        var time = ticketsFacade.getAllPlanes();
       /* for (CityFromDTO item: ticketsFacade.getAllCityFrom()) {
            cityFromList.add(item.cityFrom);
        }
        for (CityToDTO item: ticketsFacade.getAllCityTo()) {
            cityToList.add(item.city_to);
        }

        model.setCityToList(cityToList);
        model.setCityFromList(cityFromList);*/
        return "home";
    }


    @PostMapping("/home")
    public String FilterTicket(@ModelAttribute("model") CityTicketDTO model){
        LocalDate date = LocalDate.parse(model.getDataTime());
        Long id = 1l;
       // var id = ticketsFacade.getTicket(model.getCityFromList().stream().findFirst().get(), model.getCityToList().stream().findFirst().get(), date);
       // if(id == null){
         //   return "redirect:/home?error";
        //}
        return "redirect:/catalog/tickets?id_ticket=" + id +"&date_ticket=" + date;
    }
    @GetMapping("/showUserInfo")
    public String getUser(@CurrentSecurityContext SecurityContext context, HttpServletRequest request,
                          HttpSession session){
        String user = SecurityUtil.getUsername();
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    UserDetail detail = (UserDetail) authentication.getPrincipal();
    var ite = detail.getUsername();
    System.out.println(detail.getUser());
    return "home";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }


}
