package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.entity.Result;
import edu.akdeniz.softeng.surveyrest.repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author maemresen
 * <p>
 * Service to results.
 */
@Controller
@RequestMapping("/service")
public class ResultService {

    private final ResultRepo resultRepo;

    @Autowired
    public ResultService(ResultRepo resultRepo) {
        this.resultRepo = resultRepo;
    }

    @ResponseBody
    @GetMapping("/resultList")
    public List<Result> getResultList() {
        return new NotNullList<>(resultRepo.findAll());
    }


    public String getResultComment(String uid, String surveyId, String questionId) {
        List<Result> resultList = resultRepo.findByUidAndSurveyIdAndQuestionId(uid, surveyId, questionId);
        if (resultList == null || resultList.isEmpty()) {
            return "";
        }
        return resultList.get(0).getComment();
    }

    public boolean selected(String uid, String surveyId, String questionId, String answerId) {
        List<Result> resultList = resultRepo.findByUidAndSurveyIdAndQuestionIdAndChoiceId(uid, surveyId, questionId, answerId);
        return !resultList.isEmpty();
    }


}
