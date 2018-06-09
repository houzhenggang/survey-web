package edu.akdeniz.softeng.surveyrest.controller;

import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/**
 * @author maemresen
 * <p>
 * Controller to handle end-user opearations like loading pages etc.
 */
@Controller
public class HomeController {

    private final SurveyService surveyService;

    @Autowired
    public HomeController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping(value = {"/", "/home"})
    public String homePage(ModelMap model) {
        return "redirect:/surveys";
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

    @PostMapping("/survey/end")
    public SurveyResult end(@ModelAttribute("surveyResult") SurveyResult surveyResult) {
        return surveyResult;
    }


    /* Secured */

    @GetMapping("/secure/survey/{surveyId}/edit")
    public String edit(Model model, @PathVariable String surveyId) {
        model.addAttribute("survey", surveyService.getSurvey(surveyId));
        return "edit";
    }

    @GetMapping("/secure/survey/create")
    public String create() {
        return "create";
    }


}