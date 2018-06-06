package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.entity.Answer;
import edu.akdeniz.softeng.surveyrest.entity.Question;
import edu.akdeniz.softeng.surveyrest.entity.Survey;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class SurveyService {

    private final SurveyRepo repository;

    @Autowired
    public SurveyService(SurveyRepo repository) {
        this.repository = repository;
    }

    //survey list, create, save, show, delete, edit, update, takesurvey is created

    // {"_id": "q1", "type": "question",
    // "type": "multiplechoice", "question": "Best team?", "answers": ["Galatasaray", "Fenerbahçe", "Beşiktaş"]},

    public Survey getDummySurvey() {

        Answer a1 = new Answer();
        a1.setAnswerText("a1");

        Answer a2 = new Answer();
        a2.setAnswerText("a2");


        Answer a3 = new Answer();
        a3.setAnswerText("a2");


        Answer a4 = new Answer();
        a4.setAnswerText("a2");

        Question q1 = new Question();
        q1.setQuestionText("q1");
        q1.setAnswerList(Arrays.asList(a1, a2));
        q1.setQuestionType(Question.QuestionType.MULTI_ANSWER);

        Question q2 = new Question();
        q2.setQuestionText("q2");
        q2.setAnswerList(Arrays.asList(a3, a4));
        q2.setQuestionType(Question.QuestionType.SINGLE_ANSWER);

        // save a couple of customers
        Survey survey = new Survey();
        survey.setSurveyTitle("Survey " + UUID.randomUUID().toString());
        survey.setSurveyQuestions(Arrays.asList(q1, q2));
        return survey;
    }

    public List<Survey> testDB() {
        repository.deleteAll();
        repository.save(getDummySurvey());
        repository.save(getDummySurvey());
        return repository.findAll();
    }


    public List<Survey> getSurveyList() {
        return new NotNullList<>(repository.findAll());
    }

    // .......................................

    // TODO : no need

    public String create() {
        // TODO : parameters? returns what?
        return "create";
    }


    public Survey save(Survey survey) {
        repository.save(survey);
        return survey;
    }

    public Survey show(String id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Survey survey) {
        repository.delete(survey);
    }

    // TODO : take survey ??

    // TODO : delete survey ??

    // TODO : edit survey??

}
