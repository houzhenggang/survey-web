package edu.akdeniz.softeng.surveyrest.controller;

import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.model.SurveyModel;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.service.manipulation.ResultManipulationService;
import edu.akdeniz.softeng.surveyrest.service.manipulation.SurveyManipulationService;
import edu.akdeniz.softeng.surveyrest.util.helper.SecurityHelper;
import edu.akdeniz.softeng.surveyrest.util.helper.SurveyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


/**
 * @author maemresen
 */
@Controller
public class ManipulationController {

    private final SurveyHelper surveyHelper;
    private final SurveyService surveyService;
    private final SurveyManipulationService surveyManipulationService;
    private final ResultManipulationService resultManipulationService;

    @Autowired
    public ManipulationController(SurveyHelper surveyHelper, SurveyService surveyService, SurveyManipulationService surveyManipulationService, ResultManipulationService resultManipulationService) {
        this.surveyHelper = surveyHelper;
        this.surveyService = surveyService;
        this.surveyManipulationService = surveyManipulationService;
        this.resultManipulationService = resultManipulationService;
    }

    /* Secured */

    @PostMapping("/secure/survey/create")
    public String create(@ModelAttribute("survey") Survey survey, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Your survey successfully created");
        redirectAttributes.addFlashAttribute("status", "success");
        String surveyId = surveyManipulationService.create(survey);
        return "redirect:/secure/survey/" + surveyId + "/edit";
    }

    @PostMapping("/secure/survey/save")
    public String save(@ModelAttribute("survey") Survey survey, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Your changes successfully changed");
        redirectAttributes.addFlashAttribute("status", "info");
        String surveyId = surveyManipulationService.save(survey);
        return "redirect:/secure/survey/" + surveyId + "/edit";
    }

    @ResponseBody
    @GetMapping("/secure/survey/clear")
    public List<Survey> clearDB() {
        return surveyHelper.clearDB();
    }

    @ResponseBody
    @GetMapping("/secure/survey/reset")
    public List<Survey> resetDB() {
        return surveyHelper.resetDB();
    }

    @PostMapping("/survey/end")
    public String end(@ModelAttribute("surveyResult") SurveyResult surveyResult, @RequestParam("surveyId") String surveyId, Model model) {
        String uid = resultManipulationService.save(surveyResult);
        SurveyModel surveyModel = surveyService.getSurveyModelBySurveyResult(uid, surveyId);
        if (surveyModel == null) {
            model.addAttribute("errMsg", "No Result Found");
            return "error";
        }
        model.addAttribute("surveyModel", surveyModel);
        return "result";
    }

}