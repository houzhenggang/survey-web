package edu.akdeniz.softeng.surveyrest.repository;

import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author maemresen
 */
public interface ChoiceRepo extends MongoRepository<Choice, String> {
}
