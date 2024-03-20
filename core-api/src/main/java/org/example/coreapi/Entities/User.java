package org.example.coreapi.Entities;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(unique = true, nullable = false)
    private String firstName;

    @Column(unique = true, nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private BigInteger phoneNumber;

    @Column(unique = true, nullable = false)
    private int age;

    @Column(unique = true, nullable = false)
    private String gender;

    @Column(unique = true, nullable = false)
    private BigInteger aadharNumber;

    @Column(unique = true, nullable = false)
    private String address;




}
