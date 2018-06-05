package edu.akdeniz.softeng.surveyrest.controller;


import edu.akdeniz.softeng.surveyrest.entity.Answer;
import edu.akdeniz.softeng.surveyrest.entity.Question;
import edu.akdeniz.softeng.surveyrest.entity.Survey;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/survey")
public class SurveyController {

    private final SurveyRepo repository;

    @Autowired
    public SurveyController(SurveyRepo repository) {
        this.repository = repository;
    }

    //survey list, create, save, show, delete, edit, update, takesurvey is created

    // {"_id": "q1", "type": "question",
    // "type": "multiplechoice", "question": "Best team?", "answers": ["Galatasaray", "Fenerbahçe", "Beşiktaş"]},


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
        survey.setSurveyDescription("Survey1");
        survey.setSurveyQuestions(Arrays.asList(q1, q2));
        repository.save(survey);

        // ...
        survey = new Survey();
        survey.setSurveyDescription("Survey2");
        survey.setSurveyQuestions(Arrays.asList(q1, q2));
        repository.save(survey);

        return repository.findAll();
    }


    @ResponseBody
    @GetMapping("/list")
    public List<Survey> getSurveyList() {
        return repository.findAll();
    }


    // .......................................

    // TODO : no need

    @ResponseBody
    @RequestMapping("/create")
    public String create() {
        // TODO : parameters? returns what?
        return "create";
    }


    @ResponseBody
    @RequestMapping("/save")
    public String save(@RequestBody Survey survey) {
        // TODO : update vs save
        return survey.getSurveyId();
    }

    @ResponseBody
    @RequestMapping("/show/{id}")
    public Survey show(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    // TODO : take survey ??

    // TODO : delete survey ??

    // TODO : edit survey??
}
