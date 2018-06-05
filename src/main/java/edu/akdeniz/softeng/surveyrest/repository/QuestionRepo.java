package edu.akdeniz.softeng.surveyrest.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepo extends MongoRepository<QuestionRepo, Long> {

    // TODO : addAnswer ??
}
