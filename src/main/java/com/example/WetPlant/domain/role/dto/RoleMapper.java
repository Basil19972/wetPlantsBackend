package com.example.WetPlant.domain.role.dto;

import com.example.WetPlant.core.generic.ExtendedMapper;
import com.example.WetPlant.domain.role.Role;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends ExtendedMapper<Role, RoleDTO> {
}
