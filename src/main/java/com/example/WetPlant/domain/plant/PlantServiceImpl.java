package com.example.WetPlant.domain.plant;

import com.example.WetPlant.core.generic.ExtendedRepository;
import com.example.WetPlant.core.generic.ExtendedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantServiceImpl extends ExtendedServiceImpl<Plant> implements PlantService {

    @Autowired
    protected PlantServiceImpl(ExtendedRepository<Plant> repository) {
        super(repository);
    }




}
