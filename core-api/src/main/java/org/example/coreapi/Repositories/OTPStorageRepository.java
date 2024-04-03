package org.example.coreapi.Repositories;
import org.example.coreapi.Entities.OTPStorage;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Repository
public interface OTPStorageRepository extends CrudRepository<OTPStorage, Long> {

    @Query("SELECT o FROM OTPStorage o WHERE o.email = :to")
    OTPStorage findEmail(String to);

    @Modifying
    @Transactional
    @Query("UPDATE OTPStorage o SET o.generatedOTP = :generatedOTP, o.expirationTime = :expirationTime WHERE o.email = :to")
    void update(String to, Instant expirationTime,String generatedOTP);



}
