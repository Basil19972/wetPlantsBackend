package com.example.WetPlant.domain.user;

import com.example.WetPlant.core.generic.ExtendedService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface UserService extends UserDetailsService, ExtendedService<User> {

    User getCurrentUser();
    User register(User user);
    User lockUser(UUID id);





}



