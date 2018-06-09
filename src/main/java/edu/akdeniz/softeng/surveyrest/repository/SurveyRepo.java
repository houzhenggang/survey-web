package edu.akdeniz.softeng.surveyrest.repository;


import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author maemresen
 */
public interface SurveyRepo extends MongoRepository<Survey, String> {
}
