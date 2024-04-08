package org.example.coreapi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long department_id;

    private String department_name;

    @ManyToMany(mappedBy = "department")
    @JsonIgnore
    List<Hospital> hospital;


}
