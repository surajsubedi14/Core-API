package org.example.coreapi.Services;

import org.example.coreapi.Entities.Doctor;
import org.example.coreapi.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    public DoctorRepository doctorRepository;
    public Doctor addDoctor(Doctor doctor) { return doctorRepository.save(doctor); }


}
