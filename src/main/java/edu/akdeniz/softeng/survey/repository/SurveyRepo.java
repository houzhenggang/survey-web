package edu.akdeniz.softeng.survey.repository;

import edu.akdeniz.softeng.survey.entity.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SurveyRepo extends MongoRepository<Survey, Long> {

}
