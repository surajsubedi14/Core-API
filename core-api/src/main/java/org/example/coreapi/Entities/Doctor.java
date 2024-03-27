package org.example.coreapi.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
@Table(name ="doctors")
@PrimaryKeyJoinColumn(name ="user_id")

public class Doctor extends User {

    private String registrationNumber;

    private String degree;

    private boolean availability;

    private String seniorityLevel;

    private int rating;

    private String specialization;

    private int yearOfExp;

    @ManyToOne
    @JoinColumn(name ="hospital_id")
    private Hospital hospital;

}
