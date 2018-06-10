package edu.akdeniz.softeng.surveyrest.service.manipulation;

import edu.akdeniz.softeng.surveyrest.entity.Result;
import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import edu.akdeniz.softeng.surveyrest.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maemresen
 * <p>
 * Manipulation Service to manipulate results
 */
@Service
public class ResultManipulationService {

    private final ResultRepo resultRepo;

    @Autowired
    public ResultManipulationService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    public void deleteAll() {
        resultRepo.deleteAll();
    }


    public Result save(Result result) {
        resultRepo.save(result);
        return result;
    }

    public void save(List<Result> results) {
        results.forEach(this::save);
    }

    public void save(SurveyResult surveyResult) {
        save(surveyResult.getResults());
    }

}
