package org.example.coreapi.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
public class OTPStorage {
    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String generatedOTP;

    private Instant expirationTime;

}
