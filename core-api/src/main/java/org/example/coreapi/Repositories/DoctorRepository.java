package org.example.coreapi.Repositories;

import org.example.coreapi.Entities.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {

    @Query("SELECT d from Doctor d where d.seniorityLevel = ?1")
    Iterable<Doctor> getDoctorsBySeniority(String name);

    @Query("SELECT d from Doctor d where d.user_id = ?1")
    Optional<Doctor> findById(Long id);
}
