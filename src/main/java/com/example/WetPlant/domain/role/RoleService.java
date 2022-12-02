package com.example.WetPlant.domain.role;

import com.example.WetPlant.core.generic.ExtendedService;

public interface RoleService extends ExtendedService<Role> {
    Role GetDefaultRole();
}
