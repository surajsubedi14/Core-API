package org.example.coreapi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private float rating;

    private String specialization;

    private int yearOfExp;

    private String role;

    @ManyToOne
    @JoinColumn(name ="hospital_id")
    @JsonIgnore
    private Hospital hospital;

}
