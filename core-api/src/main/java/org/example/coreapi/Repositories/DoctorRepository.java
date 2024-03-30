package org.example.coreapi.Repositories;

import org.example.coreapi.Entities.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {

    @Query("SELECT d from Doctor d where d.seniorityLevel = ?1")
    Iterable<Doctor> getDoctorsBySeniority(String name);


}
