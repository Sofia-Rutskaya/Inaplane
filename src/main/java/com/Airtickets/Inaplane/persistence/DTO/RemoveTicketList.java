package com.Airtickets.Inaplane.persistence.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RemoveTicketList  extends BaseDTO {
    private List<RemoveTicketsDto> tickets;
    private int CurrentPage;
}
