package org.example.coreapi.Services;

import org.example.coreapi.Entities.Department;
import org.example.coreapi.Entities.Hospital;
import org.example.coreapi.Repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServices {
    @Autowired
    public HospitalRepository hospitalRepository;
    public List<Hospital> getAllHospitalDetails() {
        return (List<Hospital>) hospitalRepository.findAll(); }

    public Optional<Hospital> getSpecificHospitalDetails(@PathVariable int id)
    {
        return hospitalRepository.findById(id);
    }

    public Hospital existHospital (String email) { return hospitalRepository.findByEmail(email); }

    public Hospital addHospital(Hospital hospital) { return hospitalRepository.save(hospital); }

    public List<Department>findALLDepartmentByHospitalId(long id)
    {
        return (List<Department>) hospitalRepository.getDepartmentByID(id);
    }

    public Hospital getHospitalByEmail(String email){return hospitalRepository.findByEmail(email);}

    public  Hospital getHospital(Long id ){return  hospitalRepository.getHospitalById(id);}




}





