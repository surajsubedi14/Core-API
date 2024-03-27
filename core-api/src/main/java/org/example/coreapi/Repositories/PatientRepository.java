package org.example.coreapi.Repositories;

import org.example.coreapi.Entities.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Long> {

    @Query("SELECT p from Patient p where p.user_id = ?1")
    Optional<Patient> findById(Long id);
}
