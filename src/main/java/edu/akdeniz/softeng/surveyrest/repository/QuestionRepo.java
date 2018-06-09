package edu.akdeniz.softeng.surveyrest.repository;


import edu.akdeniz.softeng.surveyrest.entity.survey.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author maemresen
 */
public interface QuestionRepo extends MongoRepository<Question, String> {
}
