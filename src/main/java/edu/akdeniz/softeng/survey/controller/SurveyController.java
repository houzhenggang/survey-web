package edu.akdeniz.softeng.survey.controller;

import edu.akdeniz.softeng.survey.entity.Survey;
import edu.akdeniz.softeng.survey.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("/survey")
public class SurveyController {

    @Autowired
    private SurveyRepo repository;

    @ResponseBody
    @GetMapping("/reset")
    public List<Survey> resetDB() {
        repository.deleteAll();

        // save a couple of customers
        Survey survey;

        // ...
        survey = new Survey(1, "Survey1");
        repository.save(survey);

        // ...
        survey = new Survey(2, "Survey2");
        repository.save(survey);

        return repository.findAll();
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Survey> getSurveyList() {
        return repository.findAll();
    }
}
