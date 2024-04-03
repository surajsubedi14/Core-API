package org.example.coreapi.Repositories;

import jakarta.transaction.Transactional;
import org.example.coreapi.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long > {

    @Query("SELECT e FROM User e WHERE e.user_id = 1")
    Patient findPatient(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.email = :email, p.phoneNumber = :phone, p.age = :age, p.city = :address, p.password = :password, p.weight = :weight, p.height = :height WHERE p.user_id = :id")
    void updatePatientDetails( Long id,String email, String phone, int age, String address, String password, double weight, double height);

    @Query("SELECT p FROM Patient p WHERE p.email = :email ")
    Patient existsByUsername(String email);
}
