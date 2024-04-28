package org.example.coreapi.Services;
import org.example.coreapi.Entities.Doctor;
import org.example.coreapi.Entities.EHR;
import org.example.coreapi.Entities.Feedback;
import org.example.coreapi.Repositories.EHRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;


import java.time.LocalDate;
import java.util.Date;
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
    public  List<Object[]> getEhrRecordsForMonitoringPage(@PathVariable long seniorDoctorId)
    {
        return ehrRepository.getEhrRecordsForMonitoringPage(seniorDoctorId);
    }

    public Optional<List<EHR>> getRepeatedPatient(@PathVariable long patient_id , @PathVariable long doctor_id){
        return ehrRepository.getRepeatedPatient(patient_id, doctor_id);
    }

    public Optional<EHR> getEHRRecordById(@PathVariable long id){
        return ehrRepository.findById((int) id);
    }

    public EHR addRecord(EHR ehr) { return ehrRepository.save(ehr); }

    public boolean updateRecordDetails(EHR ehr) {
        ehrRepository.updateRecordDetails(ehr.getEhr_id(), ehr.getDuration());
        return true;
    }
    public LocalDate getLastAppointmentDate(long patient_id,long doctor_id){
         return ehrRepository.getLastAppointmentDate(patient_id,doctor_id);
    }

    public boolean updatePrescriptionDetails(EHR ehr) {
        ehrRepository.updatePrescriptionDetails(ehr.getEhr_id(), ehr.getReason(), ehr.getFollow_up_date(), ehr.getPrescription_url());
        return true;
    }

    public String getPrescription(long id){
        return ehrRepository.getPrescriptionById(id);
    }

    public Long totalConsulation(){return ehrRepository.totalConsulation();}
}
