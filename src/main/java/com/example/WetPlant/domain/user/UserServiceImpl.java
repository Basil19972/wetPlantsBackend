package com.example.WetPlant.domain.user;

import com.example.WetPlant.core.exception.CantDeleteAdminException;
import com.example.WetPlant.core.generic.ExtendedRepository;
import com.example.WetPlant.core.generic.ExtendedServiceImpl;
import com.example.WetPlant.core.security.config.Roles;
import com.example.WetPlant.domain.role.Role;
import com.example.WetPlant.domain.role.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;


@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;


    @Autowired
    public UserServiceImpl(ExtendedRepository<User> repository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleService roleService) {
        super(repository);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
    }







    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return ((UserRepository) super.getRepository()).findByEmail(email).map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException(email));
    }


    @Override
    public User register(User user1) {


        user1.setPassword(bCryptPasswordEncoder.encode(user1.getPassword()));
        user1.setNotLocked(true);
        user1.setRoles(new HashSet<Role>(Arrays.asList(roleService.GetDefaultRole())));


        return super.getRepository().save(user1);


    }

    @Override
    public User lockUser(UUID id) {

        User user = ((UserRepository) super.getRepository()).findById(id).orElseThrow();

        for (Role role : user.getRoles()) {

            if (role.equals(roleService.findById(UUID.fromString(Roles.ADMIN.getUuid())))) {
                throw new CantDeleteAdminException("You cant delete an other Admin");
            }


        }
        findById(user.getId());
        user.setNotLocked(false);
        return updateById(user.getId(), user);
    }

    public User getCurrentUser(){
        //Get User UUID
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        User user = ((UserDetailsImpl) principal).user();
        return user;
    }
}
