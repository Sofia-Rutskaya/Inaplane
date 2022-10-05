package com.Airtickets.Inaplane.persistence.repository.UserRepo;

import com.Airtickets.Inaplane.persistence.entity.Users.UsersData;
import com.Airtickets.Inaplane.persistence.repository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDataRepository extends IBaseRepository<UsersData> {
}
