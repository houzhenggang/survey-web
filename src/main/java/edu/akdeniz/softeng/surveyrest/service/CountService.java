package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.constant.Constants.QuestionType;
import edu.akdeniz.softeng.surveyrest.entity.Count;
import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;
import edu.akdeniz.softeng.surveyrest.entity.survey.Question;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.model.Answer;
import edu.akdeniz.softeng.surveyrest.model.QuestionModel;
import edu.akdeniz.softeng.surveyrest.model.SurveyModel;
import edu.akdeniz.softeng.surveyrest.repository.CountRepo;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import edu.akdeniz.softeng.surveyrest.util.helper.SecurityHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author maemresen
 * <p>
 * Service for surveys.
 */
@Controller
@RequestMapping("/service/")
public class CountService {

    private final CountRepo counterRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(CountService.class.getName());

    @Autowired
    public CountService(CountRepo counterRepo) {
        this.counterRepo = counterRepo;
    }


    public int getCountByQuestionIdAndChoiceId(String questionId, String choiceId) {
        List<Count> result = counterRepo.findByQuestionIdAndChoiceId(questionId, choiceId);
        LOGGER.info(result+" is result");
        List<Count> counts = new NotNullList<>(result);
        if (counts.isEmpty()) {
            LOGGER.warn(String.format("No Result Found for questionId=[%s] and choiceId=[%s]", questionId, choiceId));
            return 0;
        }
        Count count = counts.get(0);
        if (count == null) {
            LOGGER.error("Count is null");
            return 0;
        }
        return count.getCount();
    }


}
