package org.example.coreapi.Services;

import org.example.coreapi.Entities.Doctor;
import org.example.coreapi.Entities.Hospital;
import org.example.coreapi.Entities.Patient;
import org.example.coreapi.Entities.User;
import org.example.coreapi.Repositories.DoctorRepository;
import org.example.coreapi.Repositories.HospitalRepository;
import org.example.coreapi.Repositories.PatientRepository;
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
    @Autowired
    public PatientRepository patientRepository;

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

    public boolean updateUserDetails(Long id, Patient patient) {

        patientRepository.updatePatientDetails(id,patient.getEmail(),patient.getPhoneNumber(),patient.getAge(),patient.getCity(),patient.getPassword(), patient.getHeight(), patient.getWeight());
        return true;
    }
    public  User getUser(Long id)
    {
        return userRepository.findByUserId(id);
    }




}
