package com.example.WetPlant.domain.plant;

import com.example.WetPlant.core.EmailServiceImpl;
import com.example.WetPlant.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {

    private final PlantService plantService;
    private final UserService userService;

    @Autowired
    public PlantController(PlantService plantService, UserService userService) {
        this.plantService = plantService;
        this.userService = userService;
    }


    @GetMapping("")
    @PreAuthorize("hasAuthority('PLANTS_READ')")

    public ResponseEntity<List<Plant>> findAll() {
        List<Plant> plants = plantService.findAllbyUser();
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('PLANTS_WRITE')")
    public ResponseEntity<Plant> createNewWorkout(@RequestBody  Plant plant) {
        plant.setDate(LocalDate.now());
        plant.setCreatedBy(userService.getCurrentUser());
        return new ResponseEntity<>(plantService.save(plant), HttpStatus.CREATED);
    }





}
