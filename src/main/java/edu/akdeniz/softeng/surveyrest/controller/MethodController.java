package edu.akdeniz.softeng.surveyrest.controller;

import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MethodController {

    @ResponseBody
    @PostMapping("/survey/end")
    public SurveyResult end(@ModelAttribute("surveyResult") SurveyResult surveyResult) {
        return surveyResult;
    }

}
