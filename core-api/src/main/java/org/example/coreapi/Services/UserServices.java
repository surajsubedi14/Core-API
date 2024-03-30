package org.example.coreapi.Services;

import org.example.coreapi.Entities.Doctor;
import org.example.coreapi.Entities.Patient;
import org.example.coreapi.Entities.User;
import org.example.coreapi.Repositories.DoctorRepository;
import org.example.coreapi.Repositories.HospitalRepository;
import org.example.coreapi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.print.Doc;

@Service
public class UserServices {
    @Autowired
    public  UserRepository userRepository;
    @Autowired
    public DoctorRepository doctorRepository;
    @Autowired
    public HospitalRepository  hospitalRepository;

    public User existUser(Doctor doctor)
    {
        return userRepository.findByEmails(doctor.getEmail());
    }
    public  User addDoctor(Doctor doctor)
    {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctor(long id)
    {
        return (List<Doctor>) hospitalRepository.getDoctorById(id);
    }
    public User addHospitalToUser(User user)
    {
        return userRepository.save(user);
    }


}
