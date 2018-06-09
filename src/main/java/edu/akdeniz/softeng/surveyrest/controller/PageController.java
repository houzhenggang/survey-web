package edu.akdeniz.softeng.surveyrest.controller;

import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.util.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {


    private final SurveyService surveyService;

    @Autowired
    public PageController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping(value = {"/", "/home"})
    public String homePage(ModelMap model) {
        return "welcome";
    }

    @GetMapping("/surveys")
    public String surveys(Model model) {
        model.addAttribute("surveyList", surveyService.getSurveyList());
        return "surveys";
    }

    @GetMapping(value = {"/survey/{surveyId}", "/survey"})
    public String apply(Model model, @PathVariable(required = false) String surveyId) {
        if (surveyId == null) {
            return "redirect:/surveys";
        }
        model.addAttribute("survey", surveyService.getSurvey(surveyId));
        return "apply";
    }


    /* Secured */

    @GetMapping("/secure/survey/edit/{surveyId}")
    public String edit(Model model,@PathVariable String surveyId) {
        model.addAttribute("survey",surveyService.getSurvey(surveyId));
        return "create";
    }

    @GetMapping("/secure/survey/create")
    public String create() {
        return "create";
    }

}