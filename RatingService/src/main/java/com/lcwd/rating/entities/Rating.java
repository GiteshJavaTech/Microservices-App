package com.lcwd.rating.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.NONE)
public class Rating {
    @JsonProperty("ratingId")
    private String ratingId;
}
