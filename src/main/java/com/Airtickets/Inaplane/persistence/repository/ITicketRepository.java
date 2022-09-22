package com.Airtickets.Inaplane.persistence.repository;
import com.Airtickets.Inaplane.persistence.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ITicketRepository extends IBaseRepository<Tickets> {
}
