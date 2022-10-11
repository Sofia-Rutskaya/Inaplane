package com.Airtickets.Inaplane.persistence.repository.UserRepo;

import com.Airtickets.Inaplane.persistence.entity.Tickets.UsersTicket;
import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.persistence.repository.IBaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsersTicketsRepository extends IBaseRepository<UsersTicket> {
    @Modifying
    @Query(value = "delete from UsersTicket u where u.id = :id")
    void deleteUsersTicketById(@Param("id") Long id);
}
