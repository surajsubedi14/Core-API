package org.example.coreapi.Services;

import org.example.coreapi.Entities.Doctor;
import org.example.coreapi.Entities.Feedback;
import org.example.coreapi.Entities.Hospital;
import org.example.coreapi.Repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

   @Autowired
    public FeedbackRepository feedbackRepository;
    public boolean updateFeedback(Long id, Feedback feedback) {

        feedbackRepository.updateFeedback(id, feedback.getOneStar(),feedback.getTwoStar(),feedback.getThreeStar()
        ,feedback.getFourStar(),feedback.getFiveStar(),feedback.getNo_of_reviews());
        return true;
    }
    public Feedback getFeedbacksByDoctorId(Long doctor_id)
    {

         return feedbackRepository.getFeedbacksByDoctorID(doctor_id);
    }
    public Feedback addFeedback(Feedback feedback) { return feedbackRepository.save(feedback); }


}
