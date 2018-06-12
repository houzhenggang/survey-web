package edu.akdeniz.softeng.surveyrest.controller;

import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.util.LoggerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author maemresen
 * <p>
 * Controller to handle end-user opearations like loading pages etc.
 */
@Controller
public class HomeController {

    LoggerWrapper logger = new LoggerWrapper(HomeController.class);

    private final SurveyService surveyService;

    @Autowired
    public HomeController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping(value = {"/", "/home"})
    public String homePage() {
        logger.info("redirecting home page .............");
        return "redirect:/surveys";
    }

    @GetMapping("/surveys")
    public String surveys(Model model) {
        logger.info("home page .............");
        model.addAttribute("surveyList", surveyService.getSurveyList());
        return "surveys";
    }

    @GetMapping(value = {"/survey/{surveyId}/take", "/survey/take"})
    public String apply(Model model, @PathVariable(required = false) String surveyId) {
        if (surveyId == null) {
            return "redirect:/surveys";
        }
        Survey survey = surveyService.getSurvey(surveyId);
        if (survey == null) {
            return "redirect:/surveys";
        }
        model.addAttribute("survey", survey);
        return "take";
    }



    /* Secured */

    @GetMapping(value = {"/secure/survey/{surveyId}/edit", "/secure/survey/edit"})
    public String edit(Model model, @PathVariable(required = false) String surveyId) {
        if (surveyId == null) {
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