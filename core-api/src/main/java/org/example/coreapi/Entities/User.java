package org.example.coreapi.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column( nullable = false)
    private String firstName;

    @Column( nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private BigInteger phoneNumber;

    @Column( nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    @Column(unique = true, nullable = false)
    private BigInteger aadharNumber;

    @Column(nullable = false)
    private String address;

    @Column( nullable = false)
    private String password;

    @Column( nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private boolean active;
}
