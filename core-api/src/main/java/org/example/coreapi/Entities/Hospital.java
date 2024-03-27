package org.example.coreapi.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hospital_id;

    @Column(nullable = false)
    private String name;

    @Column( nullable = false)
    private String email;

    @Column(nullable = false)
    private BigInteger phoneNumber;

    @Column (nullable = false)
    private String address;

    @Column( nullable = false)
    private String registrationNumber;

    @Column( nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private float rating;

    @Column( nullable = false)
    private String website;

    @Column(nullable = false)
    private String category;

    @OneToMany
    @JoinColumn(name = "doctor_id")
    private Set<Doctor> doctors;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "Hospital_Department", joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Set<Department> departments;


}
