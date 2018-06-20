package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.constant.Constants.QuestionType;
import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;
import edu.akdeniz.softeng.surveyrest.entity.survey.Question;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.model.Answer;
import edu.akdeniz.softeng.surveyrest.model.QuestionModel;
import edu.akdeniz.softeng.surveyrest.model.SurveyModel;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import edu.akdeniz.softeng.surveyrest.util.helper.SecurityHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author maemresen
 * <p>
 * Service for surveys.
 */
@Controller
@RequestMapping("/service")
public class SurveyService {

    private final SurveyRepo surveyRepo;
    private final ResultService resultService;
    private final SparkService sparkService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyService.class.getName());

    @Autowired
    public SurveyService(SurveyRepo surveyRepo, ResultService resultService, SparkService sparkService) {
        this.surveyRepo = surveyRepo;
        this.resultService = resultService;
        this.sparkService = sparkService;
    }

    // ....
    public Survey getSurvey(String id) {
        return surveyRepo.findById(id).orElse(null);
    }

    @ResponseBody
    @GetMapping("/surveyList")
    public List<Survey> getSurveyList() {
        List<Survey> result = new NotNullList<>(surveyRepo.findAll());
        LOGGER.debug("Surveys : " + result);
        if (result.isEmpty()) {
            LOGGER.warn("No Survey Found");
        } else {
            LOGGER.info(String.format("Surveys listed by [%s]", SecurityHelper.getUserName()));
        }
        return result;
    }


    /**/

    /**
     * find survey results for given survey session
     *
     * @param uid      id of survey session
     * @param surveyId id of survey
     * @return answers given to the questions
     */
    public SurveyModel getSurveyModelBySurveyResult(String uid, String surveyId) {
        Survey survey = getSurvey(surveyId);
        if (survey == null) {
            LOGGER.error(String.format("No Result found for Survey[%s]", surveyId));
            return null;
        }
        List<QuestionModel> questionModelList = getQuestionModelList(uid, surveyId, survey.getQuestions());
        SurveyModel surveyModel = new SurveyModel(survey, questionModelList);
        LOGGER.info(String.format("Answers listed of Survey[%s] with uid=[%s] to [%s]", surveyId, uid, SecurityHelper.getUserName()));
        return surveyModel;
    }

    private List<QuestionModel> getQuestionModelList(String uid, String surveyId, List<Question> questionList) {
        List<QuestionModel> questionModelList = new NotNullList<>();
        for (Question question : questionList) {

            String comment;
            List<Answer> answerList;

            // behaviour according to question type
            if (question.getTypeEnum() == QuestionType.OPEN_ENDED) {
                answerList = NotNullList.emptyList();
                comment = resultService.getResultComment(uid, surveyId, question.getId());
            } else {
                answerList = getAnswerModelList(uid, surveyId, question.getId(), question.getChoices());
                comment = "";
            }

            // .....
            questionModelList.add(new QuestionModel(question, answerList, comment));
        }
        return questionModelList;
    }

    private List<Answer> getAnswerModelList(String uid, String surveyId, String questionId, List<Choice> choiceList) {
        List<Answer> answerList = new NotNullList<>();
        int answerCount = sparkService.getAnswerCountByQuestionIdAndChoiceList(questionId,choiceList);
        for (Choice choice : choiceList) {
            String choiceId = choice.getId();
            boolean selected = resultService.selected(uid, surveyId, questionId, choiceId);
            int count = sparkService.getCountByQuestionIdAndChoiceId(questionId, choiceId);
            double percentage = ((double) (100 * count)) / ((double) answerCount);
            LOGGER.debug(String.format("count=[%d], answerCount=[%d], percentage=[%.2f]", count, answerCount, percentage));
            answerList.add(new Answer(choice, selected, count, percentage));
        }
        return answerList;
    }

}
