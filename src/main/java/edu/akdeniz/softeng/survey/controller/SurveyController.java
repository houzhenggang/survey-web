package edu.akdeniz.softeng.survey.controller;

import edu.akdeniz.softeng.survey.entity.Answer;
import edu.akdeniz.softeng.survey.entity.Question;
import edu.akdeniz.softeng.survey.entity.Survey;
import edu.akdeniz.softeng.survey.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/survey")
public class SurveyController {

    @Autowired
    private SurveyRepo repository;

    @ResponseBody
    @GetMapping("/reset")
    public List<Survey> resetDB() {
        repository.deleteAll();

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
        Survey survey;

        // ...
        survey = new Survey();
        survey.setName("Survey1");
        survey.setQuestionList(Arrays.asList(q1, q2));
        repository.save(survey);

        // ...
        survey = new Survey();
        survey.setName("Survey2");
        survey.setQuestionList(Arrays.asList(q1, q2));
        repository.save(survey);

        return repository.findAll();
    }


    @ResponseBody
    @GetMapping("/list")
    public List<Survey> getSurveyList() {
        return repository.findAll();
    }
}
