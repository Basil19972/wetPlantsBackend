package com.example.WetPlant.domain.role;

import com.example.WetPlant.core.generic.ExtendedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends ExtendedRepository<Role> {


    Role findByName(String name);


}
