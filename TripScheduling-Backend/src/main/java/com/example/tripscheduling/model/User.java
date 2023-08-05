package com.example.tripscheduling.model;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    boolean isLogged;
}
