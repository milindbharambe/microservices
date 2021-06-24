package com.milind.microservices.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.milind.microservices.sample.domain.MyUser;
import com.milind.microservices.sample.repo.EmpUserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmpUserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser empUser = userRepo.findByUserName(username);
        if (empUser == null) {
            throw new UsernameNotFoundException("User not found..!!");
        }
        return new CustomUserDetails(empUser);
    }

}
