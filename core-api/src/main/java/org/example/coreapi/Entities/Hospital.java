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

    private String name;

    private String email;

    private String phoneNumber;

    private String address;

    private String registrationNumber;

    private String imgUrl;

    private float rating;

    private String website;

    private String category;

    private String password;

    private String pincode;

    private String role;

    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctors;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(name = "Hospital_Department", joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Set<Department> departments;


}
