package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import com.maemresen.jutils.helper.ConsoleHelper;
import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;
import edu.akdeniz.softeng.surveyrest.entity.survey.Question;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.model.AnswerModel;
import edu.akdeniz.softeng.surveyrest.model.QuestionModel;
import edu.akdeniz.softeng.surveyrest.model.SurveyModel;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author maemresen
 * <p>
 * Service for surveys.
 */
@Service
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

    public List<Survey> getSurveyList() {
        return new NotNullList<>(surveyRepo.findAll());
    }


    /**/
    public SurveyModel getSurveyModelBySurveyId(SurveyResult surveyResult) {
        return getSurveyModelBySurveyId(surveyResult.getSurveyId());
    }

    public SurveyModel getSurveyModelBySurveyId(String surveyId) {
        Survey survey = getSurvey(surveyId);
        List<QuestionModel> questionModelList = getQuestionModelList(surveyId, survey.getQuestions());
        SurveyModel surveyModel = new SurveyModel(survey, questionModelList);
        ConsoleHelper.printAction(() -> {
            System.out.println(surveyModel);
        }, "printing survey model");
        return surveyModel;
    }

    private List<QuestionModel> getQuestionModelList(String surveyId, List<Question> questionList) {
        List<QuestionModel> questionModelList = new NotNullList<>();
        for (Question question : questionList) {
            List<AnswerModel> answerModelList = getAnswerModelList(surveyId, question.getId(), question.getChoices());
            questionModelList.add(new QuestionModel(question, answerModelList));
        }
        return questionModelList;
    }

    private List<AnswerModel> getAnswerModelList(String surveyId, String questionId, List<Choice> choiceList) {
        List<AnswerModel> answerModelList = new NotNullList<>();
        for (Choice choice : choiceList) {
            answerModelList.add(new AnswerModel(choice, resultService.selected(surveyId, questionId, choice.getId())));
        }
        return answerModelList;
    }


}
