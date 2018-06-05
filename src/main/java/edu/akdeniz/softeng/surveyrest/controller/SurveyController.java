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
