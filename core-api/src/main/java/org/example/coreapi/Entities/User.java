package org.example.coreapi.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String role;

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
    private BigInteger aadhar;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column( nullable = false)
    private String password;

    @Column( nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private boolean active;
}
