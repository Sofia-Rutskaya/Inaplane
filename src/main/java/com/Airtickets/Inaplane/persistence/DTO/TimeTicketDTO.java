package com.Airtickets.Inaplane.persistence.DTO;

import javax.persistence.Column;
import java.util.Date;

public class TimeTicketDTO extends BaseDTO{
    public Long id;
    public Date dateFrom;

    public TimeTicketDTO(Long id, Date dateFrom, Long city_from_id) {
        this.id = id;
        this.dateFrom = dateFrom;
        this.city_from_id = city_from_id;
    }

    public Long city_from_id;
}
