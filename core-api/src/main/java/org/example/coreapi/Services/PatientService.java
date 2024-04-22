package org.example.coreapi.Services;

import org.example.coreapi.Entities.Hospital;
import org.example.coreapi.Entities.Patient;
import org.example.coreapi.Entities.User;
import org.example.coreapi.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient registerPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public boolean updateUserDetails(Long id, Patient patient) {

        patientRepository.updatePatientDetails(id, patient.getEmail(), patient.getPhoneNumber(), patient.getAge(), patient.getCity(), patient.getPassword(), patient.getHeight(), patient.getWeight(),patient.getBloodGroup(),patient.getDocument_url());
        return true;
    }
    public Patient existPatient (String email) { return patientRepository.existsByUsername(email); }

    public Optional<Patient> getPatientDetails(long id){return patientRepository.findById(id);}


    public Patient updatePasswordPatient(Patient patient){return patientRepository.save(patient);}


}
