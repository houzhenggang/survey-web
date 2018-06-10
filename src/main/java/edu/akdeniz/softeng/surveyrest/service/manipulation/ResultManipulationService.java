package edu.akdeniz.softeng.surveyrest.service.manipulation;

import edu.akdeniz.softeng.surveyrest.entity.Result;
import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import edu.akdeniz.softeng.surveyrest.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author maemresen
 * <p>
 * Manipulation Service to manipulate results
 */
@Controller
public class ResultManipulationService {

    private final ResultRepo resultRepo;

    @Autowired
    public ResultManipulationService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    public void deleteAll() {
        resultRepo.deleteAll();
    }


    public void save(Result result, String uid) {
        result.setUid(uid);
        resultRepo.save(result);
    }

    public void save(List<Result> results, String uid) {
        results.forEach(result -> save(result, uid));
    }

    public String save(SurveyResult surveyResult) {
        String uid = UUID.randomUUID().toString();
        save(surveyResult.getResults(), uid);
        return uid;
    }

}
