package com.Airtickets.Inaplane.persistence.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CityTicketDTO extends BaseDTO{
    Long id;
    List<String> cityFromList;
    List<String> cityToList;
    String dataTime;
}
