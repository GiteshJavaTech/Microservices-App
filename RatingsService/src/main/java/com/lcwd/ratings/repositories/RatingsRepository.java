package com.lcwd.ratings.repositories;

import com.lcwd.ratings.entities.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingsRepository extends MongoRepository<Ratings, String> {

    //custome finder method
    List<Ratings> findByUserId(String userId);

    List<Ratings> findByHotelId(String hotelId);

}
