package com.Airtickets.Inaplane.persistence.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RemoveTicketList {
    public List<RemoveTicketsDto> tickets;
}
