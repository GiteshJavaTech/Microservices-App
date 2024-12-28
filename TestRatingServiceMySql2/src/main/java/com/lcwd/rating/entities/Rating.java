package com.lcwd.rating.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="micro_rating")
public class Rating {

    @Id
    @Column(name="ID")
    private String ratingId;
    @Column(name = "RATING")
    private  int rating;
}
