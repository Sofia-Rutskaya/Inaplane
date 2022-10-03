package com.Airtickets.Inaplane.persistence.repository.UserRepo;

import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.persistence.repository.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends IBaseRepository<RegisteredUser> {
    @Query(value = "select r from RegisteredUser r where r.fullName = :username")

    RegisteredUser findByUsername(@Param("username") String username);
}
