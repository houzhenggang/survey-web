package edu.akdeniz.softeng.surveyrest.controller.secure;

import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/secure")
public class SecureMethodController {

    private final SurveyService surveyService;

    @Autowired
    public SecureMethodController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    /* Secured */

    @PostMapping("/survey/create")
    public String create(@ModelAttribute("survey") Survey survey) {
        surveyService.save(survey);
        return "redirect:/secure/survey/" + survey.getSurveyId();
    }

    @PostMapping("/survey/save")
    public String save(@ModelAttribute("survey") Survey survey) {
        surveyService.save(survey);
        return "redirect:/secure/survey/" + survey.getSurveyId() + "/edit";
    }

}