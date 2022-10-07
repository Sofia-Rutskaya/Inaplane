package com.Airtickets.Inaplane.facade;

import com.Airtickets.Inaplane.facade.interfaces.ITicketsFacade;
import com.Airtickets.Inaplane.persistence.DTO.CityFromDTO;
import com.Airtickets.Inaplane.persistence.DTO.CityToDTO;
import com.Airtickets.Inaplane.persistence.DTO.TicketsDTO;
import com.Airtickets.Inaplane.persistence.entity.Tickets.*;
import com.Airtickets.Inaplane.service.interfaces.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TicketsFacade implements ITicketsFacade {
    private final ITicketsService ticketService;

    private final IToService toService;

    private final IFromService fromService;

    private final IPlaneService planeService;

    public TicketsFacade( ITicketsService ticketService,
                          IToService toService,
                          IFromService fromService,
                          IPlaneService planeService) {
        this.ticketService = ticketService;
        this.planeService = planeService;
        this.fromService = fromService;
        this.toService = toService;
    }

    public List<TicketsDTO> getAllTickets (){
        var ticket = ticketService.getAllTickets();

        List<TicketsDTO> items = new ArrayList<>();

        for (Tickets ticketDto:
             ticket) {
            TicketsDTO ticketsDTO = new TicketsDTO(ticketDto);
            items.add(ticketsDTO);
        }

        return items;
    }

    public void createTicket(@RequestBody Tickets  ticket){
        ticketService.create(ticket);
    }

    public Tickets getTicketById(@PathVariable Long id){
        return ticketService.getById(id);
    }

    public Long getTicket(String cityFrom, String cityTo, LocalDate datatime){

         return ticketService.getTicket(cityFrom, cityTo, datatime);
    }


    public void deleteTickets(@PathVariable Long id){
        ticketService.delete(id);
    }

    public List<CityFromDTO> getAllCityFrom (){
        var city = fromService.getAllItem();
        List<CityFromDTO> items = city.stream().map(CityFromDTO:: new).collect(Collectors.toList());

        return items;
    }


    public void createFrom(@RequestBody CityFrom from){
        fromService.create(from);
    }


    public CityFrom getFromById(@PathVariable Long id){
        return fromService.getById(id);
    }


    public void deleteFrom(@PathVariable Long id){
        fromService.delete(id);
    }


    public List<CityToDTO> getAllCityTo (){
        var city = toService.getAllItem();
        List<CityToDTO> items = city.stream().map(CityToDTO:: new).collect(Collectors.toList());

        return items;
    }


    public void createTo(@RequestBody CityTo cityTo){
        toService.create(cityTo);
    }

    public CityTo getToById(@PathVariable Long id){
        return toService.getById(id);
    }


    public void deleteTo(@PathVariable Long id){
        toService.delete(id);
    }


    public List<Plane> getAllPlanes (){
        var plane = planeService.getAllItem();
        return plane;
    }

    public void createPlane(@RequestBody Plane plane){
        planeService.create(plane);
    }


    public Plane getPlaneById(@PathVariable Long id){
        return planeService.getById(id);
    }


    public void deletePlane(@PathVariable Long id){
        planeService.delete(id);
    }


    public TimeTicket getTimeById (@PathVariable Long id){
        return fromService.getTimeById(id);
    }

    public List<TimeTicket> getTime (){
        return fromService.getTime();
    }
}
