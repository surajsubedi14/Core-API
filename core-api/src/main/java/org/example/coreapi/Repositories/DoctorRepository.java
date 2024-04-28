package org.example.coreapi.Repositories;

import jakarta.transaction.Transactional;
import org.example.coreapi.Entities.Doctor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {

//    @Query("SELECT d from Doctor d where d.seniorityLevel = ?1")
//    Iterable<Doctor> getDoctorsBySeniority(String name);

    @Query("select d from Doctor d where d.hospital=?1")
    List<Doctor> getDoctorDetails(long id);

    @Query("select d from Doctor d where d.user_id=?1")
    Doctor getDoctorById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Doctor p SET p.email = :email, p.phoneNumber = :phone, p.age = :age, " +
            "p.state = :state, p.degree =:degree, p.specialization =:specialization," +
            "p.yearOfExp =:experience WHERE p.user_id = :id")
    void updateDoctorDetails( Long id,String email, String phone, int age, String state, String degree,
                              String specialization, int experience);
}
