package com.example.WetPlant.domain.plant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {

    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @Autowired


    @CrossOrigin(origins = {})
    @GetMapping("")
    public ResponseEntity<List<Plant>> findAll() {
        List<Plant> plants = plantService.findAll();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }
    @CrossOrigin(origins = {})
    @PostMapping("")
    public ResponseEntity<Plant> createNewWorkout(@RequestBody  Plant plant) {

        plant.setDate(LocalDate.now());

        return new ResponseEntity<>(plantService.save(plant), HttpStatus.CREATED);
    }





}
