package com.Airtickets.Inaplane.persistence.repository.UserRepo;

import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.persistence.repository.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IUserRepository extends IBaseRepository<RegisteredUser> {
    @Query(value = "select r from RegisteredUser r where r.fullName = :username")

    Optional<RegisteredUser> findByUsername(@Param("username") String username);
}
