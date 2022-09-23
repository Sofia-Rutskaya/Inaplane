package com.Airtickets.Inaplane.controller;
import com.Airtickets.Inaplane.service.FromService;
import com.Airtickets.Inaplane.service.PlaneService;
import com.Airtickets.Inaplane.service.TicketsService;
import com.Airtickets.Inaplane.service.ToService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Airtickets.Inaplane.persistence.entity.*;

import java.util.List;

@RestController
@RequestMapping("/Catalog")
class BffController {
    Logger logger = LoggerFactory.getLogger(BffController.class);

    private final TicketsService ticketService;

    private final ToService toService;

    private final FromService fromService;

    private final PlaneService planeService;

    public BffController( TicketsService ticketService,
                          ToService toService,
                          FromService fromService,
                          PlaneService planeService) {
        this.ticketService = ticketService;
        this.planeService = planeService;
        this.fromService = fromService;
        this.toService = toService;
    }

    @GetMapping("/Tickets")
    public List<Tickets> getAllTickets (){
         var ticket = ticketService.getAllTickets();
        return ticket;
    }

    @PostMapping("/Ticket")
    public void createTicket(@RequestBody  Tickets  ticket){
        ticketService.create(ticket);
    }

    @GetMapping("/Ticket/{id}")
    public Tickets getTicketById(@PathVariable Long id){
        return ticketService.getById(id);
    }

    @DeleteMapping("/Tickets/{id}")
    public void deleteTickets(@PathVariable Long id){
        ticketService.delete(id);
    }

    @GetMapping("/From")
    public List<CityFrom> getAllCityFrom (){
         var city = fromService.getAllItem();
        return city;
    }

    @PostMapping("/From")
    public void createFrom(@RequestBody CityFrom from){
        fromService.create(from);
    }

    @GetMapping("/From/{id}")
    public CityFrom getFromById(@PathVariable Long id){
        return fromService.getById(id);
    }

    @DeleteMapping("/From/{id}")
    public void deleteFrom(@PathVariable Long id){
        fromService.delete(id);
    }

    @GetMapping("/To")
    public List<CityTo> getAllCityTo (){
        var city = toService.getAllItem();
        return city;
    }

    @PostMapping("/To")
    public void createTo(@RequestBody  CityTo  cityTo){
        toService.create(cityTo);
    }

    @GetMapping("/To/{id}")
    public CityTo getToById(@PathVariable Long id){
        return toService.getById(id);
    }

    @DeleteMapping("/To/{id}")
    public void deleteTo(@PathVariable Long id){
        toService.delete(id);
    }

    @GetMapping("/Plane")
    public List<Plane> getAllPlanes (){
        var plane = planeService.getAllItem();
        return plane;
    }

    @PostMapping("/Plane")
    public void createPlane(@RequestBody  Plane plane){
        planeService.create(plane);
    }

    @GetMapping("/Plane/{id}")
    public Plane getPlaneById(@PathVariable Long id){
        return planeService.getById(id);
    }

    @DeleteMapping("/Plane/{id}")
    public void deletePlane(@PathVariable Long id){
        planeService.delete(id);
    }

    @GetMapping("/Time/{id}")
    public TimeTicket getTimeById (@PathVariable Long id){
        return fromService.getTimeById(id);
    }
    @GetMapping("/Time")
    public List<TimeTicket> getTime (){
        return fromService.getTime();
    }
}