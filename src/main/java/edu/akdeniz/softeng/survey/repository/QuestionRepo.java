package edu.akdeniz.softeng.survey.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface QuestionRepo extends MongoRepository<QuestionRepo, Long> {

    // TODO : addAnswer ??
}
