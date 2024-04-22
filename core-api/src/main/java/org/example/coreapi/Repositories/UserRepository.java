package org.example.coreapi.Repositories;

import org.example.coreapi.Entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    @Query("SELECT e FROM User e WHERE e.email = ?1 ")
    User findByEmails(String email);

    @Query("SELECT e FROM User e WHERE e.user_id = ?1 ")
    User findByUserId(Long id);
    @Query("SELECT u FROM User u WHERE u.phoneNumber = ?1 ")
    User findByMobileNumber(String mobileNumber);

    @Query("SELECT u FROM User u WHERE u.phoneNumber = ?1  OR u.email = ?2")
    User findByNumberAndEmail(String number, String email);

}
