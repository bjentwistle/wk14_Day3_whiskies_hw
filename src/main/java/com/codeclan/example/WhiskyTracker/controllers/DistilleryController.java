package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DistilleryController {

    private final DistilleryRepository distilleryRepository;

    public DistilleryController(DistilleryRepository distilleryRepository) {
        this.distilleryRepository = distilleryRepository;
    }

    @GetMapping(value = "/distilleries")//RequestParam
    public ResponseEntity<List<Distillery>> findDistilleryByRegion(@RequestParam(name = "byRegion", required = false) String region){
        //browser query http://localhost:8080/distilleries?byRegion=Highland
        if(region != null) {
            return new ResponseEntity<>(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/distilleries/{id}")
    //browser query http://localhost:8080/distilleries/1
    public Distillery getDistilleryById(@PathVariable int id) {
        return distilleryRepository.findDistilleryById((long) id);
    }

}
