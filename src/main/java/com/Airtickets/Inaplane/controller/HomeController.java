package com.Airtickets.Inaplane.controller;

import com.Airtickets.Inaplane.facade.interfaces.ITicketsFacade;
import com.Airtickets.Inaplane.persistence.DTO.CityFromDTO;
import com.Airtickets.Inaplane.persistence.DTO.CityTicketDTO;
import com.Airtickets.Inaplane.persistence.DTO.CityToDTO;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    private final ITicketsFacade ticketsFacade;

    public HomeController( ITicketsFacade iTicketsFacade) {
        this.ticketsFacade = iTicketsFacade;
    }

    @GetMapping("/home")
    public String homePage(@ModelAttribute("model") CityTicketDTO model){
        List<String> cityFromList = new ArrayList<>();
        List<String> cityToList = new ArrayList<>();
        for (CityFromDTO item: ticketsFacade.getAllCityFrom()) {
            cityFromList.add(item.cityFrom);
        }
        for (CityToDTO item: ticketsFacade.getAllCityTo()) {
            cityToList.add(item.city_to);
        }

        model.setCityToList(cityToList);
        model.setCityFromList(cityFromList);
        return "home";
    }


    @PostMapping("/home")
    public String FilterTicket(@ModelAttribute("model") CityTicketDTO model){
        LocalDate date = LocalDate.parse(model.getDataTime());
        var id = ticketsFacade.getTicket(model.getCityFromList().stream().findFirst().get(), model.getCityToList().stream().findFirst().get(), date);

        return "redirect:/catalog/tickets?id_ticket=" + id +"&date_ticket=" + date;
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }


}
