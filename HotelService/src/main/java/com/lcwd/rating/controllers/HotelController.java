package com.lcwd.rating.controllers;

import com.lcwd.rating.entities.Hotel;
import com.lcwd.rating.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.get(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel(){
        return ResponseEntity.ok(hotelService.getAll());
    }

    @GetMapping("/test")
    public ResponseEntity check(){
        return ResponseEntity.ok("success to run");
    }

}

//error
//https://stackoverflow.com/questions/49034254/spring-boot-whitelabel-error-page-type-not-found-status-404

// to learn
//https://stackoverflow.com/questions/75819750/why-postman-is-giving-404-error-even-though-the-application-is-running-successfu