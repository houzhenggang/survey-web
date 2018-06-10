package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import com.maemresen.jutils.helper.ConsoleHelper;
import edu.akdeniz.softeng.surveyrest.entity.Result;
import edu.akdeniz.softeng.surveyrest.model.SurveyModel;
import edu.akdeniz.softeng.surveyrest.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maemresen
 * <p>
 * Service to results.
 */
@Service
public class ResultService {

    private final ResultRepo resultRepo;

    @Autowired
    public ResultService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    public List<Result> getResultList() {
        return new NotNullList<>(resultRepo.findAll());
    }

    public boolean selected(String surveyId, String questionId, String answerId) {
        List<Result> resultList = resultRepo.findBySurveyIdAndQuestionIdAndAnswerId(surveyId, questionId, answerId);
        return !resultList.isEmpty();
    }


}
