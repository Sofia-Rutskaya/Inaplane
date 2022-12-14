package com.Airtickets.Inaplane.facade;

import com.Airtickets.Inaplane.facade.interfaces.ITicketsFacade;
import com.Airtickets.Inaplane.persistence.DTO.*;
import com.Airtickets.Inaplane.persistence.entity.Tickets.*;
import com.Airtickets.Inaplane.service.interfaces.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class TicketsFacade implements ITicketsFacade {
    private final ITicketsService ticketService;

    private final IToService toService;

    private final IFromService fromService;
    private final ITimeService timeService;

    private final IPlaneService planeService;

    public TicketsFacade(ITicketsService ticketService,
                         IToService toService,
                         IFromService fromService,
                         ITimeService timeService, IPlaneService planeService) {
        this.ticketService = ticketService;
        this.timeService = timeService;
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

    public void createTicket(@RequestBody TicketsDTO  ticketDto, @RequestBody PlaneDTO planeDto){
        try{

            Tickets ticket = new Tickets();
            ticket.setCurrency(ticketDto.getCurrency());
            ticket.setPrice(ticketDto.getPrice());
            ticket.setTimeIn(LocalTime.parse(ticketDto.getTime_in()));
            //ticketService.create(ticket);

            CityTo ticketTo = new CityTo();
            ticketTo.setCityTo(ticketDto.getCity_to());
            ticketTo.setCountryTo(ticketDto.getCountry_to());
            //ticketTo.setTicket(ticket);
            //toService.create(ticketTo);

            TimeTicket time = new TimeTicket();
            time.setTimeFrom(LocalTime.parse(ticketDto.timeBookingTicket));
            time.setDateFrom(LocalDate.parse(ticketDto.dateBookingTicket));
            timeService.create(time);

            CityFrom ticketsFrom = new CityFrom();
            ticketsFrom.setCityFrom(ticketDto.getCityFrom());
            ticketsFrom.setCountryFrom(ticketDto.getCountryFrom());
            //ticketsFrom.setTicket(ticket);
            ticketsFrom.setTimes(Arrays.asList(time));
            //fromService.create(ticketsFrom);

            Plane plane = new Plane();
            //plane.setTicket(ticket);
            plane.setPlaneName(planeDto.getPlaneName());
            plane.setAllCountPlaces(planeDto.getAllCountPlaces());
            plane.setFirstFreePlaces(planeDto.getFirstFreePlaces());
            plane.setBusinessFreePlaces(planeDto.getBusinessFreePlaces());
            plane.setEconomyFreePlaces(planeDto.getEconomyFreePlaces());
            //planeService.create(plane);

            ticket.setCityTo(ticketTo);
            ticket.setFrom(ticketsFrom);
            ticket.setPlane(plane);

            ticketService.create(ticket);

            plane.setTicket(ticket);
            ticketTo.setTicket(ticket);
            ticketsFrom.setTicket(ticket);

            planeService.create(plane);
            fromService.create(ticketsFrom);
            toService.create(ticketTo);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    public TicketsDTO getTicketById(@PathVariable Long id){
        var item = ticketService.getById(id);
        TicketsDTO newTicket = new TicketsDTO(item);
        return newTicket;
    }

    public Long getTicket(String cityFrom, String cityTo, LocalDate datatime){

         return ticketService.getTicket(cityFrom, cityTo, datatime);
    }


    public void deleteTickets(@RequestBody TicketsDTO  ticketDto){
        Long ticketId = ticketDto.id;
        Tickets tickets = ticketService.getById(ticketId);
        CityFrom from = fromService.getById(tickets.getFrom().id);
        for (TimeTicket item:
             from.getTimes()) {
            timeService.deleteById(item.id);
        }
        fromService.delete(from.id);
        toService.delete(tickets.getCityTo().id);
        planeService.delete(tickets.getPlane().id);
        ticketService.delete(ticketId);
    }

    public List<CityFromDTO> getAllCityFrom (){
        var city = fromService.getAllItem();
        List<CityFromDTO> items = city.stream().map(CityFromDTO:: new).collect(Collectors.toList());

        return items;
    }


    public CityFrom getFromById(@PathVariable Long id){
        return fromService.getById(id);
    }



    public List<CityToDTO> getAllCityTo (){
        var city = toService.getAllItem();
        List<CityToDTO> items = city.stream().map(CityToDTO:: new).collect(Collectors.toList());

        return items;
    }

    public List<PlaneDTO> getAllPlanes (){
        var plane = planeService.getAllItem();
        List<PlaneDTO> planeDto = new ArrayList<>();
        for (Plane item:
                plane) {
            planeDto.add(new PlaneDTO(item));
        }
        return planeDto;
    }


    public void createTime(@RequestBody TimeDTO time){

        TimeTicket ticket = new TimeTicket();
        ticket.setDateFrom(LocalDate.parse(time.getDate()));
        ticket.setTimeFrom(LocalTime.parse(time.getTime()));
        var city = fromService.getById(time.getId());
        Tickets tickets = ticketService.getById(time.getId());
        CityFrom from = new CityFrom();
        from.setId(time.getId());
        var list = city.getTimes();
        list.add(ticket);
        from.setTimes(list);
        from.setCountryFrom(tickets.getFrom().getCountryFrom());
        from.setCityFrom(tickets.getFrom().getCityFrom());
        from.setTicket(tickets);
        timeService.create(ticket);
        fromService.create(from);
        }


    public void deleteTime (@PathVariable Long id){
       timeService.deleteById(id);
    }
}
