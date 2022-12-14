package com.Airtickets.Inaplane.service;
import com.Airtickets.Inaplane.persistence.entity.Tickets.Tickets;
import com.Airtickets.Inaplane.persistence.entity.Tickets.TimeTicket;
import com.Airtickets.Inaplane.persistence.repository.TicketsRepo.ITicketRepository;
import com.Airtickets.Inaplane.service.interfaces.ITicketsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TicketsService implements ITicketsService {
    private ITicketRepository _ticketRepository;

    public TicketsService(ITicketRepository ticketRepository) {
        _ticketRepository = ticketRepository;
    }

    @Override
    public List<Tickets> getAllTickets() {
        var item = _ticketRepository.findAll();
        List<Tickets> list = new ArrayList<>();
        item.forEach(list :: add);
        return list;
    }

    @Override
    public void create(Tickets tickets) {
        _ticketRepository.save(tickets);
    }

    @Override
    public void update(Tickets tickets) {
        _ticketRepository.saveAndFlush(tickets);
    }

    @Override
    public Tickets getById(Long id) {
        var ticket = _ticketRepository.findById(id);
        return ticket.get();
    }

     @Override
        public Long getTicket(String cityFrom, String cityTo, LocalDate datatime) {
        var ticket = _ticketRepository.findAll();
         for (Tickets item: ticket) {

             if(item.getFrom().getCityFrom().equals(cityFrom)
                     && item.getCityTo().getCityTo().equals(cityTo)){

                 for (TimeTicket date:
                      item.getFrom().getTimes()) {
                     if(date.getDateFrom().equals(datatime)){
                         return item.getId();
                     }
                 }
             }
         }
         return null;
        }

    @Override
    public void delete(Long id) {
        _ticketRepository.deleteById(id);
    }
}
