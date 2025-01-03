package com.lcwd.ratings.services.impl;

import com.lcwd.ratings.entities.Ratings;
import com.lcwd.ratings.repositories.RatingsRepository;
import com.lcwd.ratings.services.RatingsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingsServiceImpl implements RatingsServices {
    @Autowired
    private RatingsRepository ratingsRepository;

    @Override
    public Ratings create(Ratings ratings) {
        return ratingsRepository.save(ratings);
    }

    @Override
    public List<Ratings> getRatings() {
        return ratingsRepository.findAll();
    }

    @Override
    public List<Ratings> getRatingsByUserId(String userId) {
        return ratingsRepository.findByUserId(userId);
    }

    @Override
    public List<Ratings> getRatingsByHotelId(String hotelId) {
        return ratingsRepository.findByHotelId(hotelId);
    }
}
