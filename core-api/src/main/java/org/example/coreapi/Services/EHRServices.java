package org.example.coreapi.Services;

import org.example.coreapi.Entities.EHR;
import org.example.coreapi.Repositories.EHRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EHRServices {

    @Autowired
    public EHRRepository ehrRepository;
    public Optional<List<EHR>> getNumberOFPatient(@PathVariable int id)
    {
        return ehrRepository.findByDoctorId(id);
    }

}
