package org.example.coreapi.Repositories;
import jakarta.transaction.Transactional;
import org.example.coreapi.Entities.EHR;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EHRRepository extends CrudRepository<EHR,Integer> {
    @Query("select count (e.patient_id ) from EHR e where e.doctor_id =:id")
    int findByDoctorId(long id);
    @Query("select count (e.patient_id) from EHR e where e.doctor_id=:id and e.date = CURDATE()")
    int getAllPatientForSpecificDate(long id);
    @Query("select count (e.patient_id)from EHR e where e.doctor_id=:id and e.patient_type = 'N'and e.date = CURDATE()")
    int getNonRepeatPatient(long id);
    @Query("select count (e.patient_id)from EHR e where e.doctor_id=:id and e.patient_type = 'R'and e.date = CURDATE()")
    int getRepeatPatient(long id);
    @Query("SELECT e.date, "+
            "SUM(CASE WHEN e.patient_type = 'N' THEN 1 ELSE 0 END) AS nonRepeatCount, " +
            "SUM(CASE WHEN e.patient_type = 'R' THEN 1 ELSE 0 END) AS repeatCount " +
            "FROM EHR e " +
            "WHERE e.doctor_id = :doctorId " +
            "AND e.date > :date " +
            "GROUP BY e.date")
    List<Object[]> getLastTwentyDaysRepeated(long doctorId, LocalDate date);

    @Query("select u.firstName, u.lastName, u.gender, u.age, e.date, e.reason, e.prescription_url, e.follow_up_date, e.patient_type, " +
            "p.bloodGroup, p.height, p.weight " +
            "from EHR e join User u on e.patient_id = u.user_id " +
            "JOIN Patient p on u.user_id  = p.user_id where e.doctor_id = :doctorId ORDER BY e.date DESC")
    List<Object[]>getEHRRecordsByDoctorId(long doctorId);
    @Query("SELECT e.date, e.reason,e.follow_up_date,e.prescription_url, h.name, u.firstName, u.lastName " +
        "FROM EHR e " +
        "JOIN User u ON e.doctor_id = u.user_id " +
        "JOIN Doctor d ON u.user_id = d.user_id " +
        "JOIN Hospital h ON d.hospital.hospital_id = h.hospital_id " +
        "WHERE e.patient_id =:patientId ORDER BY e.date DESC")
    List<Object[]>getEHRecordsByPatientId(long patientId);
    @Query("SELECT u.firstName, u.lastName, u.gender, u.age, e.patient_type, e.reason, d.specialization, uu.firstName, uu.lastName, u.user_id, uu.user_id,e.duration " +
            "FROM EHR e " +
            "JOIN User u ON e.patient_id = u.user_id " +
            "JOIN User uu ON e.doctor_id = uu.user_id " +
            "JOIN Doctor d ON uu.user_id = d.user_id " +
            "WHERE e.date = CURDATE() AND d.hospital.hospital_id = (SELECT hospital.hospital_id FROM Doctor WHERE user_id = :seniorDoctorId)")
    List<Object[]>getEhrRecordsForMonitoringPage(long seniorDoctorId);
    @Query("Select e from EHR e where e.patient_id =:patient_id and e.doctor_id =:doctor_id")
    Optional<List<EHR>> getRepeatedPatient(long patient_id, long doctor_id);
    @Modifying
    @Transactional
    @Query("UPDATE EHR e SET e.duration =:duration WHERE e.ehr_id =:id")
    void updateRecordDetails( Long id, Duration duration);
    @Query("SELECT MAX(e.date) FROM EHR e WHERE e.patient_id =:patient_id and e.doctor_id =:doctor_id")
    LocalDate getLastAppointmentDate(Long patient_id,Long doctor_id);

    @Modifying
    @Transactional
    @Query("UPDATE EHR e SET e.reason =:reason, e.follow_up_date =:follow_up_date, e.prescription_url =:prescription_url WHERE e.ehr_id =:id")
    void updatePrescriptionDetails(Long id, String reason, LocalDate follow_up_date, String prescription_url);

    @Query("SELECT e.prescription_url from EHR e where e.ehr_id =:id")
    String getPrescriptionById(long id);
    @Query("SELECT COUNT(e) FROM EHR e")
    Long totalConsulation();


}

