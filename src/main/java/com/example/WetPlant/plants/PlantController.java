package com.example.WetPlant.plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {

    private final PlantRepository plantRepository;

    @Autowired
    public PlantController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @CrossOrigin(origins = {})
    @GetMapping("")
    public ResponseEntity<List<Plant>> findAll() {
        List<Plant> plants = plantRepository.findAll();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }
    @CrossOrigin(origins = {})
    @PostMapping("")
    public ResponseEntity<Plant> createNewWorkout(@RequestBody  Plant plant) {

        plant.setDate(LocalDate.now());

        return new ResponseEntity<>(plantRepository.save(plant), HttpStatus.CREATED);
    }





}
