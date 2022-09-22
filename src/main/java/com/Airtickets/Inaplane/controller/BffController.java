package com.Airtickets.Inaplane.controller;
import com.Airtickets.Inaplane.persistence.repository.ITicketRepository;
import com.Airtickets.Inaplane.service.FromService;
import com.Airtickets.Inaplane.service.PlaneService;
import com.Airtickets.Inaplane.service.TicketsService;
import com.Airtickets.Inaplane.service.ToService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.*;
import com.Airtickets.Inaplane.persistence.entity.*;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;

import java.sql.Time;
import java.util.List;
import java.util.Set;

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
    public List<From> getAllCityFrom (){
         var city = fromService.getAllItem();
        return city;
    }

    @PostMapping("/From")
    public void createFrom(@RequestBody  From  from){
        fromService.create(from);
    }

    @GetMapping("/From/{id}")
    public From getFromById(@PathVariable Long id){
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
    public void createFrom(@RequestBody  CityTo  cityTo){
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
    public void createFrom(@RequestBody  Plane plane){
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

    @GetMapping("/getTime")
    public TimeTicket getTime (){
        var ticket = new TimeTicket();
        ticket.setId(2l);
        ticket.setDateFrom("12 Jun 2022");
        var from = new From();
        from.setId(1l);
        from.setCountryFrom("France");
        from.setCityFrom("Paris");
        ticket.setIdTicketsFrom(from);
        return ticket;
    }
}