package org.example.coreapi.Repositories;

import org.example.coreapi.Entities.EHR;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EHRRepository extends CrudRepository<EHR,Integer> {


    @Query("select e from EHR e where e.doctor_id =:id")
    Optional<List<EHR>> findByDoctorId(int id);
}
