package com.lcwd.rating.controllers;

import com.lcwd.rating.entities.Hotel;
import com.lcwd.rating.entities.Rating;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingCotroller {

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        System.out.println("method call");
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);

    }

    @PostMapping(value = "/create")
    @RequestMapping(value = "/create", consumes = "application/json", produces="application/json")
    public ResponseEntity<Rating> createHotel(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }

    @PostMapping("/hotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }
}
