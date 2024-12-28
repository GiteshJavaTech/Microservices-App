package com.lcwd.rating.controller;


import com.lcwd.rating.entities.Rating;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testRating")
public class TestRatingController {

    @PostMapping
    public ResponseEntity<Rating> createrating(@RequestBody Rating rating){
        System.out.println("method call");
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);

    }
}
