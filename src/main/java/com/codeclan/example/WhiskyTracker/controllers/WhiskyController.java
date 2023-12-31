package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

//    @GetMapping(value = "/whiskies")
//    public List<Whisky> getAllWhiskies(){
//        return whiskeyRepository.findAll();
//    }

    @GetMapping(value = "/whiskies") //RequestParam
    public ResponseEntity<List<Whisky>> getWhiskiesByYear(@RequestParam(name = "byYear", required = false) Integer year){
        //browser query http://localhost:8080/whiskies?byYear=1995
        if(year != null) {
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        }
    }


}
