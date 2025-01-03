package com.lcwd.ratings.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_ratings")
public class Ratings {
    @Id
    @JsonProperty("ratingId")
    private String ratingId;
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("hotelId")
    private String hotelId;
    @JsonProperty("rating")
    private  int rating;
    @JsonProperty("feedback")
    private  String feedback;
}
