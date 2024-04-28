package org.example.coreapi.Repositories;

import org.example.coreapi.Entities.Department;
import org.example.coreapi.Entities.Doctor;
import org.example.coreapi.Entities.Hospital;
import org.example.coreapi.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital,Integer> {

    @Query("select h from Hospital h where h.email = ?1")
    Hospital findByEmail(String email);

    @Query("SELECT h FROM Hospital h WHERE h.hospital_id = ?1 ")
    Hospital getHospitalById(long id);

    @Query("select h.doctor from Hospital h where h.hospital_id=?1")
    List<Doctor> getDoctorById(long id);

    @Query("select h.department from Hospital h where h.hospital_id=?1")
    List<Department> getDepartmentByID(long id);


    @Query("select COUNT(h) from Hospital h ")
    Long numberOfHospitals();
}
