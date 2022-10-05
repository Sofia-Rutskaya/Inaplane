package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.persistence.repository.UserRepo.IUserRepository;
import com.Airtickets.Inaplane.security.UserDetail;
import com.Airtickets.Inaplane.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<RegisteredUser> loadUserByUsername(String username) {
        Optional<RegisteredUser> user = userRepository.findByUsername(username);
       return user;
    }

    @Transactional
    public void register(RegisteredUser user){
        userRepository.save(user);
    }
}
