package edu.akdeniz.softeng.surveyrest.repository;

import edu.akdeniz.softeng.surveyrest.entity.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author maemresen
 */
public interface ResultRepo extends MongoRepository<Result, String> {

    List<Result> findBySurveyIdAndQuestionIdAndAnswerId(String surveyId, String questionId, String answerId);

}
