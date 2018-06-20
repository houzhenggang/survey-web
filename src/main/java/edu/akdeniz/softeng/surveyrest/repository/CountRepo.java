package edu.akdeniz.softeng.surveyrest.repository;

import edu.akdeniz.softeng.surveyrest.entity.Count;
import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author maemresen
 */
public interface CountRepo extends MongoRepository<Count, String> {
    public List<Count> findByQuestionIdAndChoiceId(String questionId, String choiceId);
}
