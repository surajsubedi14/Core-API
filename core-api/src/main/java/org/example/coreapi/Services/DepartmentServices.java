package org.example.coreapi.Services;

import org.example.coreapi.Entities.Department;
import org.example.coreapi.Entities.Hospital;
import org.example.coreapi.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServices {

    @Autowired
    public DepartmentRepository departmentRepository;


}
