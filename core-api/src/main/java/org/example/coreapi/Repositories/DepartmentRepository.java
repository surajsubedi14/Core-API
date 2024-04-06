package org.example.coreapi.Repositories;

import org.example.coreapi.Entities.Department;
import org.example.coreapi.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Integer> {

    @Query("SELECT d FROM Department d WHERE d.department_name = ?1 ")
    Department isPresent(String name);





}
