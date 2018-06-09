package edu.akdeniz.softeng.surveyrest.repository;

import edu.akdeniz.softeng.surveyrest.entity.Result;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author maemresen
 */
public interface ResultRepo extends MongoRepository<Result, String> {
}
