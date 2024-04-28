package org.example.coreapi.Repositories;

import jakarta.transaction.Transactional;
import org.example.coreapi.Entities.Feedback;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback,Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Doctor f SET f.feedback.oneStar = :one, f.feedback.twoStar = :two, " +
            "f.feedback.threeStar= :three,f.feedback.fourStar = :four,f.feedback.fiveStar = :five," +
            "f.feedback.no_of_reviews = :reviews where f.user_id = :id")
    void updateFeedback( Long id, int one,int two,int three,int four,int five,int reviews);


    @Query("SELECT f FROM Feedback f JOIN Doctor d ON f.feedback_id = d.feedback.feedback_id WHERE d.user_id = :id")
    Feedback getFeedbacksByDoctorID(long id);
}
