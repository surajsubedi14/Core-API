package org.example.coreapi.Services;

import org.example.coreapi.Entities.Patient;
import org.example.coreapi.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServices {

    @Autowired
    public PatientRepository patientRepository;
    public Optional<Patient> getPatientDetails(long id){return patientRepository.findById(id);}

    public Patient addPatient(Patient patient) { return patientRepository.save(patient); }
}
