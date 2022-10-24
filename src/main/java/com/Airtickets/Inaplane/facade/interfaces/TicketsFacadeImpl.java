package com.Airtickets.Inaplane.facade.interfaces;

import com.Airtickets.Inaplane.persistence.DTO.PlaneDTO;
import com.Airtickets.Inaplane.persistence.DTO.TicketsDTO;
import com.Airtickets.Inaplane.persistence.entity.Tickets.*;
import com.Airtickets.Inaplane.service.PlaneService;
import com.Airtickets.Inaplane.service.TicketsService;
import com.Airtickets.Inaplane.service.TimeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketsFacadeImpl implements com.Airtickets.Inaplane.facade.TicketsFacade {
    private final TicketsService ticketService;

    //private final IToService toService;

   // private final IFromService fromService;
    private final TimeService timeService;

    private final PlaneService planeService;

    public TicketsFacadeImpl(TicketsService ticketService,

                             TimeService timeService, PlaneService planeService) {
        this.ticketService = ticketService;
        this.timeService = timeService;
        this.planeService = planeService;

    }

    public List<TicketsDTO> getAllTickets (){
        var ticket = ticketService.getAllTickets();
        var plane = planeService.getAllItem();

        var time = timeService.getAll();

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
           // ticket.setTimeIn(LocalTime.parse(ticketDto.getTime_in()));
            //ticketService.create(ticket);

           // CityTo ticketTo = new CityTo();
           // ticketTo.setCityTo(ticketDto.getCity_to());
            //ticketTo.setCountryTo(ticketDto.getCountry_to());
            //ticketTo.setTicket(ticket);
            //toService.create(ticketTo);

            Schedule time = new Schedule();
           // time.setTimeFrom(LocalTime.parse(ticketDto.timeBookingTicket));
           // time.setDateFrom(LocalDate.parse(ticketDto.dateBookingTicket));
            timeService.create(time);

           // CityFrom ticketsFrom = new CityFrom();
            //ticketsFrom.setCityFrom(ticketDto.getCityFrom());
           // ticketsFrom.setCountryFrom(ticketDto.getCountryFrom());
            //ticketsFrom.setTicket(ticket);
           // ticketsFrom.setTimes(Arrays.asList(time));
            //fromService.create(ticketsFrom);

            Plane plane = new Plane();
            //plane.setTicket(ticket);
            plane.setPlaneName(planeDto.getPlaneName());
            plane.setAllCountPlaces(planeDto.getAllCountPlaces());
            plane.setFirstFreePlaces(planeDto.getFirstFreePlaces());
            plane.setBusinessFreePlaces(planeDto.getBusinessFreePlaces());
            plane.setEconomyFreePlaces(planeDto.getEconomyFreePlaces());
            //planeService.create(plane);

         //   ticket.setCityTo(ticketTo);
          //  ticket.setFrom(ticketsFrom);
            ticket.setPlane(plane);

            ticketService.create(ticket);

            plane.setTicket(ticket);
           // ticketTo.setTicket(ticket);
          //  ticketsFrom.setTicket(ticket);

            planeService.create(plane);
            //fromService.create(ticketsFrom);
            //toService.create(ticketTo);
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
      //  CityFrom from = fromService.getById(tickets.getFrom().id);
       // for (TimeTicket item:
      //       from.getTimes()) {
       //     timeService.deleteById(item.id);
    //    }
      //  fromService.delete(from.id);
      //  toService.delete(tickets.getCityTo().id);
        planeService.delete(tickets.getPlane().getId());
        ticketService.delete(ticketId);
    }
/*
    public List<CityFromDTO> getAllCityFrom (){
        var city = fromService.getAllItem();
        List<CityFromDTO> items = city.stream().map(CityFromDTO:: new).collect(Collectors.toList());

        return items;
    }



*/


   /* public void deleteFrom(@PathVariable Long id){
        fromService.delete(id);
    }
*/

   /* public List<CityToDTO> getAllCityTo (){
        var city = toService.getAllItem();
        List<CityToDTO> items = city.stream().map(CityToDTO:: new).collect(Collectors.toList());

        return items;
    }*/




   /* public void deleteTo(@PathVariable Long id){
        toService.delete(id);
    }*/


    public List<PlaneDTO> getAllPlanes (){
        var plane = planeService.getAllItem();
        List<PlaneDTO> planeDto = new ArrayList<>();
        for (Plane item:
                plane) {
            planeDto.add(new PlaneDTO(item));
        }
        return planeDto;
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


   // public Schedule getTimeById (@PathVariable Long id){
    //    return fromService.getTimeById(id);
   // }

   // public List<Schedule> getTime (){
     //   return fromService.getTime();
  //  }
}
