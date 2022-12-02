package com.example.WetPlant.domain.role;

import com.example.WetPlant.core.generic.ExtendedRepository;
import com.example.WetPlant.core.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ExtendedServiceImpl<Role> implements RoleService {

    @Autowired
    protected RoleServiceImpl(ExtendedRepository<Role> repository) {
        super(repository);
    }

    public Role GetDefaultRole() {

        return ((RoleRepository) super.getRepository()).findByName("USER");
    }


}
