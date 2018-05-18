package edu.akdeniz.softeng.survey.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface Question extends MongoRepository<Question, Long> {

}
