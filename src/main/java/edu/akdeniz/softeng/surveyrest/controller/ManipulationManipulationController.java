package edu.akdeniz.softeng.surveyrest.controller;

import com.maemresen.jutils.helper.ConsoleHelper;
import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.model.SurveyModel;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.service.manipulation.ResultManipulationService;
import edu.akdeniz.softeng.surveyrest.service.manipulation.SurveyManipulationService;
import edu.akdeniz.softeng.surveyrest.util.helper.JsonHelper;
import edu.akdeniz.softeng.surveyrest.util.helper.SurveyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author maemresen
 */
@Controller
public class ManipulationManipulationController {

    private final SurveyHelper surveyHelper;
    private final SurveyService surveyService;
    private final SurveyManipulationService surveyManipulationService;
    private final ResultManipulationService resultManipulationService;

    @Autowired
    public ManipulationManipulationController(SurveyHelper surveyHelper, SurveyService surveyService, SurveyManipulationService surveyManipulationService, ResultManipulationService resultManipulationService) {
        this.surveyHelper = surveyHelper;
        this.surveyService = surveyService;
        this.surveyManipulationService = surveyManipulationService;
        this.resultManipulationService = resultManipulationService;
    }

    /* Secured */

    @PostMapping("/secure/survey/create")
    public String create(@ModelAttribute("survey") Survey survey) {
        return "redirect:/secure/survey/" + surveyManipulationService.create(survey) + "/edit";
    }

    @PostMapping("/secure/survey/save")
    public String save(@ModelAttribute("survey") Survey survey) {
        return "redirect:/secure/survey/" + surveyManipulationService.save(survey) + "/edit";
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

    @ResponseBody
    @PostMapping("/survey/end")
    public String end(@ModelAttribute("surveyResult") SurveyResult surveyResult, Model model) {
        resultManipulationService.save(surveyResult);
        model.addAttribute("surveyModel", surveyService.getSurveyModelBySurveyId(surveyResult));
        return "result";
    }

}