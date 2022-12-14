package com.example.WetPlant.domain.user.dto;


import com.example.WetPlant.core.generic.ExtendedMapper;
import com.example.WetPlant.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends ExtendedMapper<User, UserDTO> {
    User fromUserRegisterDTO(UserRegisterDTO dto);
    User fromUserIdNameAndPriceSpendDTO(UserIdNameAndPriceSpendDTO dto);

}
