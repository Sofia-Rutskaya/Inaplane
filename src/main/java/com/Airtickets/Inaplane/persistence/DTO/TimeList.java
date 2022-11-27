package com.Airtickets.Inaplane.persistence.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TimeList extends BaseDTO {
    public List<TimeDTO> times;
    private int CurrentPage;

}
