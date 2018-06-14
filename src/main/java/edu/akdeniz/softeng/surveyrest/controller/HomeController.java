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

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class.getName());

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
        return "surveys";
    }

    @GetMapping(value = {"/survey/{surveyId}/take", "/survey/take"})
    public String apply(Model model, @PathVariable(required = false) String surveyId) {
        if (surveyId == null) {
            LOGGER.error("SurveyId is empty");
            return "redirect:/surveys";
        }
        Survey survey = surveyService.getSurvey(surveyId);
        if (survey == null) {
            LOGGER.error(String.format("Survey[%s] not found", surveyId));
            return "redirect:/surveys";
        }
        model.addAttribute("survey", survey);
        LOGGER.info(String.format("Survey[%s] is taking by [%s]", surveyId, SecurityHelper.getUserName()));
        return "take";
    }



    /* Secured */

    @GetMapping(value = {"/secure/survey/{surveyId}/edit", "/secure/survey/edit"})
    public String edit(Model model, @PathVariable(required = false) String surveyId) {
        if (surveyId == null) {
            LOGGER.warn(String.format("Survey not found"));
            return "redirect:/surveys";
        }
        model.addAttribute("survey", surveyService.getSurvey(surveyId));
        return "edit";
    }

    @GetMapping("/secure/survey/create")
    public String create() {
        return "create";
    }


}