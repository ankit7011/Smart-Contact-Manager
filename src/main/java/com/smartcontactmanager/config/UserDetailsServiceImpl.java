package com.smartcontactmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smartcontactmanager.dao.UserRepository;
import com.smartcontactmanager.entities.Users;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.getUserByUserName(username);
        System.out.println("\nUDSI -----> +\n");
        
        if(user == null)
        {
            throw new UsernameNotFoundException("Could not find user !!!");
        }
        
        CustomUserDetails customUserDetails= new CustomUserDetails(user);
        
        System.out.println("UDSI -----> ++  ");

        return customUserDetails;
    }

}
