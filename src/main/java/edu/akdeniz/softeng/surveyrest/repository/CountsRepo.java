package edu.akdeniz.softeng.surveyrest.repository;

import edu.akdeniz.softeng.surveyrest.entity.Counts;
import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author maemresen
 */
public interface CountsRepo extends MongoRepository<Counts, String> {

    public List<Counts> findByQuestionId(String questionId);
    public List<Counts> findByQuestionIdAndChoiceId(String questionId, String choiceId);
}
