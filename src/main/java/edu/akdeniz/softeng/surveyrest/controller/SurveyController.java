package edu.akdeniz.softeng.surveyrest.controller;


import edu.akdeniz.softeng.surveyrest.entity.Survey;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import edu.akdeniz.softeng.surveyrest.constant.Constants.API;

import java.util.List;

@Controller
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }


    @ResponseBody
    @GetMapping(API.SURVEY_LIST_SERVICE_URL)
    public List<Survey> getSurveyList() {
        return surveyService.getSurveyList();
    }

    // .......................................

    // TODO : no need

    @ResponseBody
    @RequestMapping(API.SURVEY_CREATE_SERVICE_URL)
    public Survey create() {
        // TODO : parameters? returns what?
        return new Survey();
    }


    @ResponseBody
    @RequestMapping(API.SURVEY_SAVE_SERVICE_URL)
    public Survey save(@RequestBody Survey survey) {
        // TODO : update vs save
        return surveyService.save(survey);
    }

    @ResponseBody
    @RequestMapping(API.SURVEY_SHOW_SERVICE_URL)
    public Survey show(@RequestParam String surveyId) {
        return surveyService.show(surveyId);
    }

    // TODO : take survey ??

    // TODO : delete survey ??

    // TODO : edit survey??
}
