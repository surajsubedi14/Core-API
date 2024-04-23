package org.example.coreapi.Services;
import org.example.coreapi.Repositories.EHRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EHRServices {

    @Autowired
    public EHRRepository ehrRepository;

    public int getNumberOFPatient(@PathVariable long id) {

        return ehrRepository.findByDoctorId(id);
    }

    public int getAllPatientForSpecificDate(@PathVariable long id) {

        return ehrRepository.getAllPatientForSpecificDate(id);
    }

    public int getNonRepeatPatient(@PathVariable long id) {

        return ehrRepository.getNonRepeatPatient(id);

    }

    public int getRepeatPatient(@PathVariable long id) {

        return ehrRepository.getRepeatPatient(id);
    }

    public List<Object[]> getLastTwentyDays(@PathVariable long id) {
        LocalDate twentyDaysAgo = LocalDate.now().minusDays(20);
        return ehrRepository.getLastTwentyDaysRepeated(id, twentyDaysAgo);
    }
    public List<Object[]>getEHRRecordsByDoctorId(@PathVariable long id){
        return ehrRepository.getEHRRecordsByDoctorId(id);
    }
    public List<Object[]>getEHRecordsByPatientId(@PathVariable long id){
        return ehrRepository.getEHRecordsByPatientId(id);
    }


}
