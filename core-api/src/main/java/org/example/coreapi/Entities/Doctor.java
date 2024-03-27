package org.example.coreapi.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
@Table(name ="doctors")
@PrimaryKeyJoinColumn(name ="user_id")

public class Doctor extends User {
    @Column(unique = true, nullable = false)
    private String registrationNumber;

    @Column(nullable = false)
    private String degree;

    @Column(nullable = false)
    private boolean availability;

    @Column(nullable = false)
    private String seniorityLevel;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private int yearOfExperience;

}
