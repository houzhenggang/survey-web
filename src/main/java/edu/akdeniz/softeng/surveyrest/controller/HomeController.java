package edu.akdeniz.softeng.surveyrest.controller;

import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.util.helper.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author maemresen
 * <p>
 * Controller to handle end-user opearations like loading pages etc.
 */
@Controller
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final SurveyService surveyService;

    @Autowired
    public HomeController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping(value = {"/", "/home"})
    public String homePage() {
        return "redirect:/surveys";
    }

    @GetMapping("/surveys")
    public String surveys(Model model) {
        model.addAttribute("surveyList", surveyService.getSurveyList());
        log.info(String.format("Surveys listed from [%s]",SecurityHelper.getUserName()));
        return "surveys";
    }

    @GetMapping(value = {"/survey/{surveyId}/take", "/survey/take"})
    public String apply(Model model, @PathVariable(required = false) String surveyId) {
        if (surveyId == null) {
            log.warn("SurveyId is empty");
            return "redirect:/surveys";
        }
        Survey survey = surveyService.getSurvey(surveyId);
        if (survey == null) {
            log.warn(String.format("Survey not found with id=[%d]", surveyId));
            return "redirect:/surveys";
        }
        model.addAttribute("survey", survey);
        return "take";
    }



    /* Secured */

    @GetMapping(value = {"/secure/survey/{surveyId}/edit", "/secure/survey/edit"})
    public String edit(Model model, @PathVariable(required = false) String surveyId) {
        if (surveyId == null) {
            log.warn(String.format("Survey not found with id=[%d]", surveyId));
            return "redirect:/surveys";
        }
        model.addAttribute("survey", surveyService.getSurvey(surveyId));
        return "edit";
    }

    @GetMapping("/secure/survey/create")
    public String create() {
        log.info("New survey created.");
        return "create";
    }


}