package com.example.loginsecurity.services;

import com.example.loginsecurity.model.Users;
import com.example.loginsecurity.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsServices implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public CustomUserDetailsServices(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = usersRepository.findByUsername(username);

        if (user.isEmpty()){
            throw new UsernameNotFoundException("User not Found");
        }


        return new CustomUserDetails(user.get());
    }
}
