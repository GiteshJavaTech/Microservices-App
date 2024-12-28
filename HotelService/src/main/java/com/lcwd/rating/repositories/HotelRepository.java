package com.lcwd.rating.repositories;

import com.lcwd.rating.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
}
