package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.persistence.repository.UserRepo.IUserRepository;
import com.Airtickets.Inaplane.service.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailService implements UserDetailsService {
    private final IUserRepository userRepository;
    @Autowired
    public UserDetailService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<RegisteredUser> user = userRepository.findByUsername(username);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not exist!");
        }
        return new UserDetail(user.get());
    }
}
