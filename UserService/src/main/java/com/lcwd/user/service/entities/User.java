package com.lcwd.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="micro_users")
public class User {

    @Id
    @Column(name="ID")
    private String userId;
    @Column(name = "NAME", length = 20)
    private String name;
    @Column(name="EMAIL")
    private String email;
    @Column(name = "ABOUT")
    private String about;

    @Transient// if we don't want to persist and just to ignore
    private List<Ratings> ratings = new ArrayList<>();
}
