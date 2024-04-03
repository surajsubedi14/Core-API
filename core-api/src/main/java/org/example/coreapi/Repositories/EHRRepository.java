package org.example.coreapi.Repositories;
import org.example.coreapi.Entities.EHR;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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


}
