package com.example.WetPlant.plants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface PlantRepository extends JpaRepository<Plant,UUID>{


}