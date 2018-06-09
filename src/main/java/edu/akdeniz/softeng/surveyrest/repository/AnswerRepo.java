package edu.akdeniz.softeng.surveyrest.repository;

import edu.akdeniz.softeng.surveyrest.entity.survey.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author maemresen
 */
public interface AnswerRepo extends MongoRepository<Answer, String> {
}
