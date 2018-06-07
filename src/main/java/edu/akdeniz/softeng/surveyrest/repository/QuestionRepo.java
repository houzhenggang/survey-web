package edu.akdeniz.softeng.surveyrest.repository;


import edu.akdeniz.softeng.surveyrest.entity.survey.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepo extends MongoRepository<Question, String> {

    // TODO : addAnswer ??
}
