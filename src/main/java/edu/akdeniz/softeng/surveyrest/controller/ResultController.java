package edu.akdeniz.softeng.surveyrest.controller;


import edu.akdeniz.softeng.surveyrest.entity.Result;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ResultController {

    private final SurveyService surveyService;

    @Autowired
    public ResultController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @ResponseBody
    @GetMapping("/result/list")
    public List<Result> getResultList() {
        return surveyService.getResultList();
    }

}
