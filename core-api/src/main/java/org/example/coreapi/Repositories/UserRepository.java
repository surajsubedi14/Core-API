package org.example.coreapi.Repositories;

import org.example.coreapi.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    @Query("SELECT e FROM User e WHERE e.email = ?1 ")
    User findByEmails(String email);

}
