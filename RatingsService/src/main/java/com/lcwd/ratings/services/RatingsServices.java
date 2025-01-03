package com.lcwd.ratings.services;

import com.lcwd.ratings.entities.Ratings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingsServices {

    //create
    Ratings create(Ratings ratings);

    // get all ratings
    List<Ratings> getRatings();

    // get all by user id
    List<Ratings> getRatingsByUserId(String userId);

    // get all by hotel id
    List<Ratings> getRatingsByHotelId(String hotelId);
}
