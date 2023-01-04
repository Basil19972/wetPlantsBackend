package com.example.WetPlant.domain.plant;

import com.example.WetPlant.core.generic.ExtendedService;

import java.util.List;

public interface PlantService extends ExtendedService<Plant> {

    List<Plant> findAllbyUser();
}
