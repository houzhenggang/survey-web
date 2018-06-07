package edu.akdeniz.softeng.surveyrest.repository;


import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurveyRepo extends MongoRepository<Survey, String> {


    // TODO : create = save ??

    // TODO : delete ??

    // TODO : save = update ??

}
