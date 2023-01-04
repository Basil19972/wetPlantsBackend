package com.example.WetPlant.domain.plant;

import com.example.WetPlant.core.generic.ExtendedRepository;
import com.example.WetPlant.domain.role.Role;
import com.example.WetPlant.domain.user.User;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Repository
public interface PlantRepository extends ExtendedRepository<Plant> {

    List<Plant> getPlantsByCreatedBy(User user);


    @Type(type = "pg-uuid")
    @Query(value = "SELECT *\n" +
            "FROM Plant as p\n" +
            "left join users u on u.id = p.created_by\n" +
            "where p.created_by = cast(:user_id as varchar)\n" +
            "ORDER BY p.created_at DESC\n" +
            "LIMIT 1;", nativeQuery = true)
    Plant findLatestPlantByUser(@Param("user_id") UUID user_id);





}