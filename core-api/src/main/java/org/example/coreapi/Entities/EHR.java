package org.example.coreapi.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class EHR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ehr_id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Duration duration;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = true)
    private String reason;

    @Column(nullable = true)
    private  long patient_id;

    @Column(nullable = true)
    private long doctor_id;

    @Column(nullable = true)
    private LocalDate follow_up_date;

    @Column(unique = false,nullable = false)
    private char patient_type;



}
