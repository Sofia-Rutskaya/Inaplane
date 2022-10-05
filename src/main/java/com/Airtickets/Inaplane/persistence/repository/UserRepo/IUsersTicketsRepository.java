package com.Airtickets.Inaplane.persistence.repository.UserRepo;

import com.Airtickets.Inaplane.persistence.entity.Tickets.UsersTicket;
import com.Airtickets.Inaplane.persistence.repository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersTicketsRepository extends IBaseRepository<UsersTicket> {
}
