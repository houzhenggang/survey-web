package edu.akdeniz.softeng.surveyrest.service.manipulation;

import edu.akdeniz.softeng.surveyrest.entity.Result;
import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import edu.akdeniz.softeng.surveyrest.repository.ResultRepo;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.util.helper.SecurityHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultManipulationService.class.getName());


    @Autowired
    public ResultManipulationService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    public void deleteAll() {
        resultRepo.deleteAll();
        LOGGER.info(String.format("All results deleted by %s", SecurityHelper.getUserName()));
    }


    public void save(Result result, String uid) {
        result.setUid(uid);
        resultRepo.save(result);
    }

    public void save(List<Result> results, String uid) {
        results.forEach(result -> save(result, uid));
        // TODO : add surveyId to survey result
    }

    public String save(SurveyResult surveyResult) {
        String uid = UUID.randomUUID().toString();
        save(surveyResult.getResults(), uid);
        LOGGER.info(String.format("All Results save with uid=[%s] by %s", uid, SecurityHelper.getUserName()));
        return uid;
    }

}
