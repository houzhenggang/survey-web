package edu.akdeniz.softeng.surveyrest.controller;

import edu.akdeniz.softeng.surveyrest.entity.Result;
import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.util.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller()
@RequestMapping("/secure")
public class MethodController {


    private final SurveyService surveyService;

    @Autowired
    public MethodController(SurveyService surveyService) {
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