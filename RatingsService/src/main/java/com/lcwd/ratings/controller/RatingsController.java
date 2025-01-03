package com.lcwd.ratings.controller;


import com.lcwd.ratings.entities.Ratings;
import com.lcwd.ratings.services.RatingsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @Autowired
    private RatingsServices ratingsServices;

    //create
    @PostMapping
    public ResponseEntity<Ratings> createRatings(@RequestBody Ratings ratings){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingsServices.create(ratings));
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Ratings>> getRatings(){
        return ResponseEntity.ok(ratingsServices.getRatings());
    }

    //get all by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Ratings>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingsServices.getRatingsByUserId(userId));
    }

    //get all by hotelId
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Ratings>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingsServices.getRatingsByHotelId(hotelId));
    }
}
