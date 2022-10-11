package com.Airtickets.Inaplane.service;

import com.Airtickets.Inaplane.persistence.entity.Tickets.UsersTicket;
import com.Airtickets.Inaplane.persistence.entity.Users.RegisteredUser;
import com.Airtickets.Inaplane.persistence.repository.UserRepo.IUserRepository;
import com.Airtickets.Inaplane.persistence.repository.UserRepo.IUsersTicketsRepository;
import com.Airtickets.Inaplane.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IUsersTicketsRepository userTicketRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(IUserRepository userRepository,IUsersTicketsRepository userTicketRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userTicketRepository = userTicketRepository;
    }

    public Optional<RegisteredUser> loadUserByUsername(String username) {
        Optional<RegisteredUser> user = userRepository.findByUsername(username);
       return user;
    }

    @Transactional
    public void register(RegisteredUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }

    public void addUserTicket(UsersTicket ticket){
        userTicketRepository.save(ticket);
    }

    public void updateUser(RegisteredUser user){
        userRepository.save(user);
    }

    public List<UsersTicket> getUserTickets(){
        return userTicketRepository.findAll();
    }
    @Transactional
    public void deleteUserTicket(Long id){
        userTicketRepository.deleteUsersTicketById(id);
    }
}
