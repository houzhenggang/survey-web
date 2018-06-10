package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import com.maemresen.jutils.helper.ConsoleHelper;
import edu.akdeniz.softeng.surveyrest.constant.Constants.QuestionType;
import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;
import edu.akdeniz.softeng.surveyrest.entity.survey.Question;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.model.Answer;
import edu.akdeniz.softeng.surveyrest.model.QuestionModel;
import edu.akdeniz.softeng.surveyrest.model.SurveyModel;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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
@RequestMapping("/service/")
public class SurveyService {

    private final SurveyRepo surveyRepo;
    private final ResultService resultService;


    @Autowired
    public SurveyService(SurveyRepo surveyRepo, ResultService resultService) {
        this.surveyRepo = surveyRepo;
        this.resultService = resultService;
    }

    // ....
    public Survey getSurvey(String id) {
        return surveyRepo.findById(id).orElse(null);
    }

    @ResponseBody
    @GetMapping("/surveyList")
    public List<Survey> getSurveyList() {
        return new NotNullList<>(surveyRepo.findAll());
    }


    /**/

    public SurveyModel getSurveyModelBySurveyResult(String uid, String surveyId) {
        Survey survey = getSurvey(surveyId);
        if (survey == null) {
            return null;
        }
        List<QuestionModel> questionModelList = getQuestionModelList(uid, surveyId, survey.getQuestions());
        SurveyModel surveyModel = new SurveyModel(survey, questionModelList);
        ConsoleHelper.printAction(() -> {
            System.out.println(surveyModel);
        }, "printing survey model");
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
        for (Choice choice : choiceList) {
            answerList.add(new Answer(choice, resultService.selected(uid, surveyId, questionId, choice.getId())));
        }
        return answerList;
    }


}
