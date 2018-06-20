package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.entity.Counts;
import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;
import edu.akdeniz.softeng.surveyrest.repository.CountsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author maemresen
 * <p>
 * Service for accessing processing data from spark.
 */
@Controller
@RequestMapping("/service/")
public class SparkService {

    private final CountsRepo counterRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(SparkService.class.getName());

    @Autowired
    public SparkService(CountsRepo counterRepo) {
        this.counterRepo = counterRepo;
    }


    public int getAnswerCountByQuestionIdAndChoiceList(String questionId, List<Choice> choiceList) {
        int answerCount = 0;
        for (Choice choice : choiceList) {
            answerCount += getCountByQuestionIdAndChoiceId(questionId, choice.getId());
        }
        return answerCount;
    }

    public int getCountByQuestionIdAndChoiceId(String questionId, String choiceId) {
        List<Counts> counts = new NotNullList<>(counterRepo.findByQuestionIdAndChoiceId(questionId, choiceId));
        LOGGER.debug(counts + " is result");
        if (counts.isEmpty()) {
            LOGGER.debug(String.format("No Result Found for questionId=[%s] and choiceId=[%s]", questionId, choiceId));
            return 0;
        }
        Counts count = counts.get(0);
        if (count == null) {
            LOGGER.error("Count is null");
            return 0;
        }
        return count.getCount();
    }


}
