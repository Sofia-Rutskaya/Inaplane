package com.Airtickets.Inaplane.facade.interfaces;

import com.Airtickets.Inaplane.persistence.DTO.ProfileTicket;
import com.Airtickets.Inaplane.persistence.DTO.UserBookingTicketDTO;
import com.Airtickets.Inaplane.persistence.DTO.UserDTO;
import com.Airtickets.Inaplane.persistence.entity.Tickets.Plane;
import com.Airtickets.Inaplane.persistence.entity.Tickets.Tickets;
import com.Airtickets.Inaplane.persistence.entity.Tickets.Schedule;
import com.Airtickets.Inaplane.persistence.entity.Tickets.UsersTicket;
import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.service.PlaneService;
import com.Airtickets.Inaplane.service.TicketsService;
import com.Airtickets.Inaplane.service.TimeService;
import com.Airtickets.Inaplane.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserFacadeImpl implements com.Airtickets.Inaplane.facade.UserFacade {
    private final UserService userService;
    private final PlaneService planeService;
    private final TimeService timeService;
    private final TicketsService ticketService;

    public UserFacadeImpl(UserService userService, PlaneService planeService, TimeService timeService, TicketsService ticketService) {
        this.userService = userService;
        this.planeService = planeService;
        this.timeService = timeService;
        this.ticketService = ticketService;
    }

    public void register(RegisteredUser user){
        userService.register(user);
    }

    public UserDTO loadUserByUsername(String username){
        var user = userService.loadUserByUsername(username);

        UserDTO userDTO = new UserDTO(user.get());
        return userDTO;
    }

    public int setPlaceNumber(UserBookingTicketDTO userBooking){

        var ticket = ticketService.getAllTickets();
       Plane plane = new Plane();
        for (Tickets item:
                ticket) {
            if(item.getId() == userBooking.id){
                plane = item.getPlane();
                break;
            }
        }

        int maxPlaceNum = 0;

        switch (userBooking.userDTO.typeClass){
            case ECONOMY_CLASS -> {
                maxPlaceNum = plane.getEconomyFreePlaces();
                plane.setEconomyFreePlaces(plane.getEconomyFreePlaces() - 1);
            }
            case FIRST_CLASS -> {

                maxPlaceNum = plane.getFirstFreePlaces();
                plane.setFirstFreePlaces(plane.getFirstFreePlaces() - 1);
            }
            case BUSINESS_CLASS ->  {

                maxPlaceNum = plane.getBusinessFreePlaces();
                plane.setBusinessFreePlaces(plane.getBusinessFreePlaces() - 1) ;
            }
        }


        var userTicket = userService.getUserTickets();
        int placeNumber = 0;
        for (UsersTicket item:
                userTicket) {
            if(item.getTicket().equals(userBooking.id)){
                if(placeNumber <= item.getPlaceNumber()){
                    placeNumber = item.getPlaceNumber();
                }
            }
        }
        placeNumber++;
        if(placeNumber>maxPlaceNum){
            placeNumber = -1;
        }


        planeService.create(plane);
        return placeNumber;

    }

    public void addTicketUser(UserBookingTicketDTO userBooking){
        LocalDate dateTicket = LocalDate.parse(userBooking.dateBookingTicket);
        LocalTime timeTicket = LocalTime.parse(userBooking.timeBookingTicket);

        var times = timeService.getAll();
        Long idTime = null;
        for (Schedule item:
             times) {
           /* if(item.getDateFrom().equals(dateTicket) && item.getTimeFrom().equals(timeTicket)){
                idTime = item.getId();
                break;
            }*/
        }
        if(idTime==null){
            return;
        }
        var ticketPlane = new Tickets();
        var tickets = ticketService.getAllTickets();
        for (Tickets item:
                tickets) {
            if(item.getId() == userBooking.id){
                ticketPlane = item;
                break;
            }
        }
        Schedule timeTicket1 = new Schedule();
        timeTicket1.setId(idTime);

        UsersTicket ticket = new UsersTicket();
        ticket.setAgeTicket(userBooking.getUserDTO().ageTicket);
        ticket.setCurrency(userBooking.currency);
        ticket.setActive(true);
        //ticket.setTicket(tickets);
        ticket.setPrice(userBooking.price);
        ticket.setTypeClass(userBooking.getUserDTO().typeClass);
        //ticket.setTimes(timeTicket1);
        ticket.setPlaceNumber(userBooking.getUserDTO().placeNumber);
        ticket.setTicket(userBooking.id);
        var user = userService.loadUserByUsername(userBooking.userDTO.fullName);


        ticketService.create(ticketPlane);
        userService.addUserTicket(ticket);
        user.get().usersTicket.add(ticket);
        userService.updateUser(user.get());

    }

    public List<ProfileTicket> getUserTickets(String username){
        var user = userService.loadUserByUsername(username);
        var userTickets = user.get().getUsersTicket();
        List<ProfileTicket> profileTicket = new ArrayList<>();
        for (UsersTicket item:
                userTickets) {
            var ticket = ticketService.getById(item.getTicket());
            profileTicket.add(new ProfileTicket(item, ticket));
        }
        return profileTicket;
    }

    public void deleteUserTicket(Long id){
        userService.deleteUserTicket(id);
    }
}
