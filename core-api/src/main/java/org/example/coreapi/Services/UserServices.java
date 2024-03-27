package org.example.coreapi.Services;

import org.example.coreapi.Entities.Doctor;
import org.example.coreapi.Entities.User;
import org.example.coreapi.Repositories.DoctorRepository;
import org.example.coreapi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
public class UserServices {
    @Autowired
    public  UserRepository userRepository;
    @Autowired
    public DoctorRepository doctorRepository;
    public User existUser(Doctor doctor)
    {
        return userRepository.findByEmails(doctor.getEmail());
    }
    public  User addDoctor(Doctor doctor)
    {
        return doctorRepository.save(doctor);
    }
}
