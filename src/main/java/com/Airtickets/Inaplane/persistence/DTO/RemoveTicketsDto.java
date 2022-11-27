package com.Airtickets.Inaplane.persistence.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RemoveTicketsDto extends BaseDTO {
    public TicketsDTO ticketsDTO;
    public PlaneDTO planes;

    public RemoveTicketsDto(TicketsDTO ticketsDTO, PlaneDTO planes) {
        this.ticketsDTO = ticketsDTO;
        this.planes = planes;
    }
}
