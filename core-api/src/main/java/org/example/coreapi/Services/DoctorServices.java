package org.example.coreapi.Services;

import org.example.coreapi.Entities.Doctor;
import org.example.coreapi.Entities.Hospital;
import org.example.coreapi.Entities.Patient;
import org.example.coreapi.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/hospital")
public class DoctorServices {

    @Autowired
    public DoctorRepository doctorRepository;

    public Optional<Doctor> getDoctorDetails(int id){
        return doctorRepository.findById(id);
    }

//    public List<Doctor> getDoctorsBySeniority(String isSenior){ return (List<Doctor>) doctorRepository.getDoctorsBySeniority(isSenior);}

    public Doctor getDoctorByUserId(Long id){return doctorRepository.getDoctorById(id);}

    public boolean updateDoctorDetails(Long id, Doctor doctor) {

        doctorRepository.updateDoctorDetails(id, doctor.getEmail(), doctor.getPhoneNumber(), doctor.getAge(), doctor.getState(),
                doctor.getDegree(),doctor.getSpecialization(),doctor.getYearOfExp());
        return true;
    }
    public Doctor updatePasswordDoctor(Doctor doctor){return doctorRepository.save(doctor);}


}
