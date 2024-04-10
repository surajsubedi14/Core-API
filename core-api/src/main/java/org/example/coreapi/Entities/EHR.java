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


    private LocalDate date;


    private Duration duration;


    private LocalTime time;


    private String reason;


    private  long patient_id;


    private long doctor_id;


    private LocalDate follow_up_date;


    private char patient_type;



}
